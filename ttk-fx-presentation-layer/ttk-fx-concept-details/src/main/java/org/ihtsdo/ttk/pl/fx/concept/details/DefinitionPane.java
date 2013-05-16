/*
 * Copyright 2013 International Health Terminology Standards Development Organisation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package org.ihtsdo.ttk.pl.fx.concept.details;

//~--- non-JDK imports --------------------------------------------------------

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.WritableValue;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;

import javafx.fxml.FXMLLoader;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import org.ihtsdo.ttk.api.ContradictionException;
import org.ihtsdo.ttk.logic.DefinitionPart;
import org.ihtsdo.ttk.logic.DefinitionPartType;
import org.ihtsdo.ttk.logic.DefinitionTree;

import static javafx.geometry.HPos.LEFT;
import static javafx.geometry.HPos.RIGHT;
import static javafx.geometry.VPos.BOTTOM;
import static javafx.geometry.VPos.CENTER;
import static javafx.geometry.VPos.TOP;

import static javafx.scene.layout.Region.USE_PREF_SIZE;

import static org.ihtsdo.ttk.logic.DefinitionPartType.AND;
import static org.ihtsdo.ttk.logic.DefinitionPartType.CONCEPT_REFERENCE_DEFINED;

//~--- JDK imports ------------------------------------------------------------

import com.sun.javafx.css.StyleableBooleanProperty;
import com.sun.javafx.css.StyleableDoubleProperty;
import com.sun.javafx.css.StyleableObjectProperty;
import com.sun.javafx.css.StyleableProperty;
import com.sun.javafx.css.converters.BooleanConverter;
import com.sun.javafx.css.converters.EnumConverter;
import com.sun.javafx.css.converters.SizeConverter;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kec
 */
public class DefinitionPane extends Pane {

   /** Field description */
   private static int NODE_WIDTH = 125;

   /**
    * Sentinel value which may be set on a child's row/column span constraint to
    * indicate that it should span the remaining rows/columns.
    */
   public static final int REMAINING = Integer.MAX_VALUE;

   /**
    *  BEGIN static methods
    */
   private static final String MARGIN_CONSTRAINT = "defpane-margin";

   /** Field description */
   private static final String HALIGNMENT_CONSTRAINT = "defpane-halignment";

   /** Field description */
   private static final String VALIGNMENT_CONSTRAINT = "defpane-valignment";

   /** Field description */
   private static final String ROW_INDEX_CONSTRAINT = "defpane-row";

   /** Field description */
   private static final String COLUMN_INDEX_CONSTRAINT = "defpane-column";

   /** Field description */
   private static final String ROW_SPAN_CONSTRAINT = "defpane-row-span";

   /** Field description */
   private static final String COLUMN_SPAN_CONSTRAINT = "defpane-column-span";

   /** Field description */
   private static final Color GRID_LINE_COLOR = Color.rgb(30, 30, 30);

   /** Field description */
   private static final double GRID_LINE_DASH = 3;

   /** Field description */
   private boolean metricsDirty = true;

   // This is set to true while in layoutChildren and set false on the conclusion.
   // It is used to decide whether to update metricsDirty in requestLayout().

   /** Field description */
   private boolean performingLayout = false;

   /** Field description */
   private DefinitionTree definitionTree;

   /** Field description */
   private DoubleProperty hgap;

   /** Field description */
   private DoubleProperty vgap;

   /** Field description */
   private ObjectProperty<Pos> alignment;

   /** Field description */
   private BooleanProperty gridLinesVisible;

   /** Field description */
   private Group gridLines;

   /**
    * Edges of the definition tree. 
    */
   private Group edges = new Group();

   /** Field description */
   private double[] rowMinHeight;

   /** Field description */
   private double[] rowPrefHeight;

   /** Field description */
   private double[] rowBaseline;

   /** Field description */
   private double[] rowHeights;

   /** Field description */
   private double[] columnMinWidth;

   /** Field description */
   private double[] columnPrefWidth;

   /** Field description */
   private double[] columnWidths;

   {
      getStyleClass().add("dl-grid");
      setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
   }

   /**
    *  END static methods
    */

   /**
    * Creates a DefinitionPane layout with hgap/vgap = 0 and TOP_LEFT alignment.
    */
   public DefinitionPane() {
      super();
      getChildren().addListener(new ListChangeListener<Node>() {
         @Override
         public void onChanged(Change<? extends Node> c) {
            requestLayout();
         }
      });
   }

   /**
    * Adds a child to the defpane at the specified column,row position.
    * This convenience method will set the defpane column and row constraints
    * on the child.
    * @param child the node being added to the defpane
    * @param columnIndex the column index position for the child within the defpane
    * @param rowIndex the row index position for the child within the defpane
    */
   public void add(Node child, int columnIndex, int rowIndex) {
      setConstraints(child, columnIndex, rowIndex);
      getChildren().add(child);
   }

   /**
    * Method description
    *
    *
    * @param areaWidths
    * @param width
    *
    * @return
    */
   private double adjustColumnWidths(double areaWidths[], double width) {
      final double snaphgap     = snapSpace(getHgap());
      final double left         = snapSpace(getInsets().getLeft());
      final double right        = snapSpace(getInsets().getRight());
      final int    numColumns   = columnWidths.length;
      final double hgaps        = snaphgap * (numColumns - 1);
      double       columnTotal  = hgaps;
      final double contentWidth = getWidth() - left - right;

      // compute non-percentage column widths
      for (int i = 0; i < numColumns; i++) {
         
            columnWidths[i] = boundedSize(areaWidths[i], columnMinWidth[i], columnPrefWidth[i]);
            columnTotal     += columnWidths[i];
      }

      double widthAvailable = ((width == -1)
                               ? prefWidth(-1)
                               : width) - left - right - columnTotal;

      // now that both fixed and percentage columns have been computed, divy up any surplus or deficit
      if (widthAvailable != 0) {

         // maybe grow or shrink column widths
         double remaining = growOrShrinkColumnWidths(Priority.ALWAYS, widthAvailable);

         remaining   = growOrShrinkColumnWidths(Priority.SOMETIMES, remaining);
         columnTotal += (widthAvailable - remaining);
      }

      return columnTotal;
   }

   /**
    * Method description
    *
    *
    * @param areaHeights
    * @param height
    *
    * @return
    */
   private double adjustRowHeights(double areaHeights[], double height) {
      final double snapvgap      = snapSpace(getVgap());
      final double top           = snapSpace(getInsets().getTop());
      final double bottom        = snapSpace(getInsets().getBottom());
      final int    numRows       = rowHeights.length;
      final double vgaps         = snapvgap * (numRows - 1);
      double       rowTotal      = vgaps;
      final double contentHeight = getHeight() - top - bottom;


      // compute non-percentage row heights
      for (int i = 0; i < numRows; i++) {
         
            rowHeights[i] = boundedSize(areaHeights[i], rowMinHeight[i], rowPrefHeight[i]);
            rowTotal      += rowHeights[i];
         
      }
/*
      double heightAvailable = ((height == -1)
                                ? prefHeight(-1)
                                : height) - top - bottom - rowTotal;

      // now that both fixed and percentage rows have been computed, divy up any surplus or deficit
      if (heightAvailable != 0) {

         // maybe grow or shrink row heights
         double remaining = growOrShrinkRowHeights(Priority.ALWAYS, heightAvailable);

         remaining = growOrShrinkRowHeights(Priority.SOMETIMES, remaining);
         rowTotal  += (heightAvailable - remaining);
      }
*/
      return rowTotal;
   }

   /**
    * The alignment of of the grid within the defpane's width and height.
    *
    * @return
    */
   public final ObjectProperty<Pos> alignmentProperty() {
      if (alignment == null) {
         alignment = new StyleableObjectProperty<Pos>(Pos.TOP_LEFT) {
            @Override
            public void invalidated() {
               requestLayout();
            }
            @Override
            public StyleableProperty getStyleableProperty() {
               return DefinitionPane.StyleableProperties.ALIGNMENT;
            }
            @Override
            public Object getBean() {
               return DefinitionPane.this;
            }
            @Override
            public String getName() {
               return "alignment";
            }
         };
      }

      return alignment;
   }

   /**
    * Method description
    *
    *
    * @param value
    * @param min
    * @param max
    *
    * @return
    */
   static double boundedSize(double value, double min, double max) {

      // if max < value, return max
      // if min > value, return min
      // if min > max, return min
      return Math.min(Math.max(value, min), Math.max(min, max));
   }

   /**
    * Method description
    *
    *
    * @param child
    * @param margin
    * @param width
    *
    * @return
    */
   private double computeChildMinAreaHeight(Node child, Insets margin, double width) {
      double top    = (margin != null)
                      ? snapSpace(margin.getTop(), isSnapToPixel())
                      : 0;
      double bottom = (margin != null)
                      ? snapSpace(margin.getBottom(), isSnapToPixel())
                      : 0;
      double alt    = -1;

      if (child.getContentBias() == Orientation.HORIZONTAL) {    // width depends on height
         alt = snapSize((width != -1)
                        ? boundedSize(width, child.minWidth(-1), child.maxWidth(-1))
                        : child.minWidth(-1));
      }

      return top + snapSize(child.minHeight(alt)) + bottom;
   }

   /**
    * Method description
    *
    *
    * @param child
    * @param margin
    * @param height
    *
    * @return
    */
   private double computeChildMinAreaWidth(Node child, Insets margin, double height) {
      double left  = (margin != null)
                     ? snapSpace(margin.getLeft(), isSnapToPixel())
                     : 0;
      double right = (margin != null)
                     ? snapSpace(margin.getRight(), isSnapToPixel())
                     : 0;
      double alt   = -1;

      if (child.getContentBias() == Orientation.VERTICAL) {    // width depends on height
         alt = snapSize((height != -1)
                        ? boundedSize(height, child.minHeight(-1), child.maxHeight(-1))
                        : child.minHeight(-1));
      }

      return left + snapSize(child.minWidth(alt)) + right;
   }

   /**
    * Method description
    *
    *
    * @param child
    * @param margin
    * @param width
    *
    * @return
    */
   private double computeChildPrefAreaHeight(Node child, Insets margin, double width) {
      double top    = (margin != null)
                      ? snapSpace(margin.getTop(), isSnapToPixel())
                      : 0;
      double bottom = (margin != null)
                      ? snapSpace(margin.getBottom(), isSnapToPixel())
                      : 0;
      double left   = (margin != null)
                      ? snapSpace(margin.getLeft(), isSnapToPixel())
                      : 0;
      double right  = (margin != null)
                      ? snapSpace(margin.getRight(), isSnapToPixel())
                      : 0;
      double alt    = -1;

      if (child.getContentBias() == Orientation.HORIZONTAL) {    // width depends on height
         alt = snapSize(boundedSize((width != -1)
                                    ? width - left - right
                                    : child.prefWidth(-1), child.minWidth(-1), child.maxWidth(-1)));
      }

      return top + snapSize(boundedSize(child.prefHeight(alt), child.minHeight(alt), child.maxHeight(alt)))
             + bottom;
   }


   /**
    * Method description
    *
    *
    * @param child
    * @param margin
    * @param height
    *
    * @return
    */
   private double computeChildPrefAreaWidth(Node child, Insets margin, double height) {
      double top    = (margin != null)
                      ? snapSpace(margin.getTop(), isSnapToPixel())
                      : 0;
      double bottom = (margin != null)
                      ? snapSpace(margin.getBottom(), isSnapToPixel())
                      : 0;
      double left   = (margin != null)
                      ? snapSpace(margin.getLeft(), isSnapToPixel())
                      : 0;
      double right  = (margin != null)
                      ? snapSpace(margin.getRight(), isSnapToPixel())
                      : 0;
      double alt    = -1;

      if (child.getContentBias() == Orientation.VERTICAL) {    // width depends on height
         alt = snapSize(boundedSize((height != -1)
                                    ? height - top - bottom
                                    : child.prefHeight(-1), child.minHeight(-1), child.maxHeight(-1)));
      }

      return left + snapSize(boundedSize(child.prefWidth(alt), child.minWidth(alt), child.maxWidth(alt)))
             + right;
   }

   /**
    * Method description
    *
    *
    * @param numColumns
    * @param heights
    */
   private void computeColumnMetrics(int numColumns, double heights[]) {
      columnMinWidth     = createDoubleArray(numColumns, 0);
      columnPrefWidth    = createDoubleArray(numColumns, 0);
      columnWidths       = createDoubleArray(numColumns, 0);

      final double snaphgap = snapSpace(getHgap());

      for (int i = 0; i < numColumns; i++) {
         boolean    computeMin  = true;
         boolean    computeMax  = true;
         boolean    computePref = true;
         boolean    computeGrow = true;
         List<Node> startNodes  = new ArrayList<>();
         List<Node> endNodes    = new ArrayList<>();

         for (int j = 0; j < getChildren().size(); j++) {
            Node child = getChildren().get(j);

            if (child.isManaged()) {
               if (getNodeColumnIndex(child) == i) {
                  startNodes.add(child);
               }

               int columnEnd = getNodeColumnEnd(child);

               if (((columnEnd == REMAINING) && (i == (numColumns - 1))) || (columnEnd == i)) {
                  endNodes.add(child);
               }
            }
         }

         if (computeMin || computeMax || computePref || computeGrow) {

            // compute from content
            for (int j = 0; j < endNodes.size(); j++) {
               Node   child       = endNodes.get(j);
               Insets margin      = getMargin(child);
               int    columnIndex = getNodeColumnIndex(child);
               int    colspan     = getNodeColumnSpan(child);

               if (colspan == REMAINING) {
                  colspan = numColumns - columnIndex;
               }

               int rowIndex = getNodeRowIndex(child);

               if (computePref) {
                  double preferredWidth = computeChildPrefAreaWidth(child, margin, heights[rowIndex]);

                  if (colspan > 1) {
                     double w = 0.0f;

                     for (int k = columnIndex; k < columnIndex + colspan - 1; k++) {
                        w += columnPrefWidth[k];
                     }

                     preferredWidth -= w + ((colspan - 1) * snaphgap);
                  }

                  columnPrefWidth[i] = Math.max(columnPrefWidth[i], preferredWidth);
               }

               if (computeMin) {
                  double minimumWidth = computeChildMinAreaWidth(child, margin, heights[rowIndex]);

                  if (colspan > 1) {
                     double w = 0.0f;

                     for (int k = columnIndex; k < columnIndex + colspan - 1; k++) {
                        w += columnMinWidth[k];
                     }

                     minimumWidth -= w + ((colspan - 1) * snaphgap);
                  }

                  columnMinWidth[i] = Math.max(columnMinWidth[i], minimumWidth);
               }
            }
         }

         if (columnMinWidth[i] == USE_PREF_SIZE) {

            // RT-20573 Use the bounded size if the pref has not been set
            columnMinWidth[i] = (columnPrefWidth[i] == 0)
                                ? (boundedSize(columnPrefWidth[i], columnMinWidth[i], columnPrefWidth[i])
                                   == USE_PREF_SIZE)
                                  ? 0
                                  : boundedSize(columnPrefWidth[i], columnMinWidth[i], columnPrefWidth[i])
                                : columnPrefWidth[i];
         }

         if (columnPrefWidth[i] == USE_PREF_SIZE) {
            columnPrefWidth[i] = (columnPrefWidth[i] == 0)
                                ? (boundedSize(columnPrefWidth[i], columnMinWidth[i], columnPrefWidth[i])
                                   == USE_PREF_SIZE)
                                  ? 0
                                  : boundedSize(columnPrefWidth[i], columnMinWidth[i], columnPrefWidth[i])
                                : columnPrefWidth[i];
         }

         columnPrefWidth[i] = boundedSize(columnPrefWidth[i], columnMinWidth[i], columnPrefWidth[i]);

         System.out.println("computeColumnMetrics: column "+i+": h="+columnWidths[i]+" min="+columnMinWidth[i]+" pref="+columnPrefWidth[i]);
      }

   }

   /**
    * Method description
    *
    */
   private void computeGridMetrics() {
      if (metricsDirty) {
         int numRows    = 0;
         int numColumns = 0;

         for (int i = 0; i < getChildren().size(); i++) {
            Node child = getChildren().get(i);

            if (child.isManaged()) {
               int rowIndex    = getNodeRowIndex(child);
               int columnIndex = getNodeColumnIndex(child);
               int rowEnd      = getNodeRowEnd(child);
               int columnEnd   = getNodeColumnEnd(child);

               numRows    = Math.max(numRows, ((rowEnd != REMAINING)
                                               ? rowEnd
                                               : rowIndex) + 1);
               numColumns = Math.max(numColumns, ((columnEnd != REMAINING)
                                                  ? columnEnd
                                                  : columnIndex) + 1);
            }
         }

         // println("computeGridMetrics: rows={numRows} columns={numColumns}");
         computeRowMetrics(numRows, createDoubleArray(numColumns, -1));
         computeColumnMetrics(numColumns, createDoubleArray(numRows, -1));
         metricsDirty = false;
      }
   }


   /**
    * Method description
    *
    *
    * @param width
    *
    * @return
    */
   @Override
   protected double computeMinHeight(double width) {
      computeGridMetrics();

      if (getContentBias() == Orientation.HORIZONTAL) {
         adjustColumnWidths(columnMinWidth, width);
         computeRowMetrics(rowHeights.length, columnWidths);
      }

      return snapSpace(getInsets().getTop())
             + (computeTotalHeight(rowMinHeight) + (rowMinHeight.length - 1) * snapSpace(getVgap()))
             + snapSpace(getInsets().getBottom());
   }

   /**
    * Method description
    *
    *
    * @param height
    *
    * @return
    */
   @Override
   protected double computeMinWidth(double height) {
      computeGridMetrics();

      if (getContentBias() == Orientation.VERTICAL) {
         adjustRowHeights(rowMinHeight, height);
         computeColumnMetrics(columnWidths.length, rowHeights);
      }

      return snapSpace(getInsets().getLeft())
             + (computeTotalWidth(columnMinWidth) + (columnMinWidth.length - 1) * snapSpace(getHgap()))
             + snapSpace(getInsets().getRight());
   }

   /**
    * Method description
    *
    *
    * @param width
    *
    * @return
    */
   @Override
   protected double computePrefHeight(double width) {
      computeGridMetrics();

      if (getContentBias() == Orientation.HORIZONTAL) {
         adjustColumnWidths(columnPrefWidth, width);
         computeRowMetrics(rowHeights.length, columnWidths);
      }

      return snapSpace(getInsets().getTop())
             + (computeTotalHeight(rowPrefHeight) + (rowPrefHeight.length - 1) * snapSpace(getVgap()))
             + snapSpace(getInsets().getBottom());
   }

   /**
    * Method description
    *
    *
    * @param height
    *
    * @return
    */
   @Override
   protected double computePrefWidth(double height) {
      computeGridMetrics();

      if (getContentBias() == Orientation.VERTICAL) {
         adjustRowHeights(rowPrefHeight, height);
         computeColumnMetrics(columnWidths.length, rowHeights);
      }

      return snapSpace(getInsets().getLeft())
             + (computeTotalWidth(columnPrefWidth) + (columnPrefWidth.length - 1) * snapSpace(getHgap()))
             + snapSpace(getInsets().getRight());
   }

   /**
    * Method description
    *
    *
    * @param numRows
    * @param widths
    */
   private void computeRowMetrics(int numRows, double widths[]) {
      rowMinHeight     = createDoubleArray(numRows, 0);
      rowPrefHeight    = createDoubleArray(numRows, 0);
      rowHeights       = createDoubleArray(numRows, 0);
      rowBaseline      = createDoubleArray(numRows, 0);

      double snapvgap = snapSpace(getVgap());

      for (int i = 0; i < numRows; i++) {
         boolean    computeMin  = true;
         boolean    computePref = true;
         List<Node> startNodes  = new ArrayList<>();
         List<Node> endNodes    = new ArrayList<>();

         for (int j = 0; j < getChildren().size(); j++) {
            Node child = getChildren().get(j);

            if (child.isManaged()) {
               if (getNodeRowIndex(child) == i) {
                  startNodes.add(child);
               }

               int rowEnd = getNodeRowEnd(child);

               if (((rowEnd == REMAINING) && (i == (numRows - 1))) || (rowEnd == i)) {
                  endNodes.add(child);
               }
            }
         }

         VPos       rowVPos       = VPos.CENTER;
         Insets     margins[]     = new Insets[startNodes.size()];
         List<Node> baselineNodes = new ArrayList<>();

         for (int j = 0, k = 0; j < startNodes.size(); j++) {
            Node n = startNodes.get(j);
         }

         rowBaseline[i] = getMaxAreaBaselineOffset(baselineNodes, margins);
         baselineNodes.clear();

         if (computeMin ||  computePref || (rowVPos == VPos.BASELINE)) {

            // compute from content
            for (int j = 0; j < endNodes.size(); j++) {
               Node   child    = endNodes.get(j);
               Insets margin   = getMargin(child);
               double top      = (margin != null)
                                 ? margin.getTop()
                                 : 0;
               int    rowIndex = getNodeRowIndex(child);
               int    rowspan  = getNodeRowSpan(child);
               int    columnSpan = getNodeColumnSpan(child);

               if (rowspan == REMAINING) {
                  rowspan = numRows - rowIndex;
               }

               int colIndex = getNodeColumnIndex(child);

               if (computePref) {
                  double widthOfColumnSpan = widths[colIndex];
                  for (int columnSpanIndex = 1; columnSpanIndex < columnSpan; columnSpanIndex++) {
                      widthOfColumnSpan += widths[colIndex + columnSpanIndex];
                  }
                  double preferredHeight = computeChildPrefAreaHeight(child, margin, widthOfColumnSpan);

                  if (rowspan > 1) {
                     double h = 0.0f;

                     for (int k = rowIndex; k < rowIndex + rowspan - 1; k++) {
                        h += rowPrefHeight[k];
                     }

                     preferredHeight -= h + ((rowspan - 1) * snapvgap);
                  } else if (rowVPos == VPos.BASELINE) {
                     preferredHeight = rowBaseline[i] + (preferredHeight - child.getBaselineOffset() - top);
                  }

                  rowPrefHeight[i] = Math.max(rowPrefHeight[i], preferredHeight);
               }

               if (computeMin) {
                  double minimumHeight = computeChildMinAreaHeight(child, margin, widths[colIndex]);

                  if (rowspan > 1) {
                     double h = 0.0f;

                     for (int k = rowIndex; k < rowIndex + rowspan - 1; k++) {
                        h += rowMinHeight[k];
                     }

                     minimumHeight -= h + ((rowspan - 1) * snapvgap);
                  } else if (rowVPos == VPos.BASELINE) {
                     minimumHeight = rowBaseline[i] + (minimumHeight - child.getBaselineOffset() - top);
                  }

                  rowMinHeight[i] = Math.max(rowMinHeight[i], minimumHeight);
               }
            }
         }

         if (rowMinHeight[i] == USE_PREF_SIZE) {

            // RT-20573 Use the bounded size if the pref has not been set
            rowMinHeight[i] = (rowPrefHeight[i] == 0)
                              ? (boundedSize(rowPrefHeight[i], rowMinHeight[i], rowPrefHeight[i])
                                 == USE_PREF_SIZE)
                                ? 0
                                : boundedSize(rowPrefHeight[i], rowMinHeight[i], rowPrefHeight[i])
                              : rowPrefHeight[i];
         }


         rowPrefHeight[i] = boundedSize(rowPrefHeight[i], rowMinHeight[i], rowPrefHeight[i]);
         System.out.println("computeRowMetrics: row "+i+": h="+rowHeights[i]+" min="+rowMinHeight[i]+" pref="+rowPrefHeight[i]);
      }

   }

   /**
    * Method description
    *
    *
    * @param heights
    *
    * @return
    */
   private double computeTotalHeight(double heights[]) {
      double totalHeight           = 0;

      for (int i = 0; i < heights.length; i++) {
            totalHeight += heights[i];
      }

      return totalHeight;
   }

   /**
    * Method description
    *
    *
    * @param widths
    *
    * @return
    */
   private double computeTotalWidth(double widths[]) {
      double totalWidth           = 0;
 
      for (int i = 0; i < widths.length; i++) {
         totalWidth += widths[i];
      }
      return totalWidth;
   }

   /**
    * Method description
    *
    *
    * @param width
    * @param contentWidth
    * @param hpos
    *
    * @return
    */
   private static double computeXOffset(double width, double contentWidth, HPos hpos) {
      switch (hpos) {
      case LEFT :
         return 0;

      case CENTER :
         return (width - contentWidth) / 2;

      case RIGHT :
         return width - contentWidth;
      }

      return 0;
   }

   /**
    * Method description
    *
    *
    * @param height
    * @param contentHeight
    * @param vpos
    *
    * @return
    */
   private static double computeYOffset(double height, double contentHeight, VPos vpos) {
      switch (vpos) {
      case TOP :
         return 0;

      case CENTER :
         return (height - contentHeight) / 2;

      case BOTTOM :
         return height - contentHeight;
      }

      return 0;
   }

   /**
    * Method description
    *
    *
    * @param length
    * @param value
    *
    * @return
    */
   private static double[] createDoubleArray(int length, double value) {
      double[] array = new double[length];

      for (int i = 0; i < length; i++) {
         array[i] = value;
      }

      return array;
   }

   /**
    * Method description
    *
    *
    * @param startX
    * @param startY
    * @param endX
    * @param endY
    *
    * @return
    */
   private Line createGridLine(double startX, double startY, double endX, double endY) {
      Line line = new Line();

      line.setStartX(startX);
      line.setStartY(startY);
      line.setEndX(endX);
      line.setEndY(endY);
      line.setStroke(GRID_LINE_COLOR);
      line.setStrokeDashOffset(GRID_LINE_DASH);

      return line;
   }


   /**
    * For debug purposes only: controls whether lines are displayed to show the defpane's rows and columns.
    * Default is <code>false</code>.
    *
    * @return
    */
   public final BooleanProperty gridLinesVisibleProperty() {
      if (gridLinesVisible == null) {
         gridLinesVisible = new StyleableBooleanProperty() {
            @Override
            protected void invalidated() {
               if (get()) {
                  gridLines = new Group();
                  gridLines.setManaged(false);
                  getChildren().add(gridLines);
               } else {
                  getChildren().remove(gridLines);
                  gridLines = null;
               }

               requestLayout();
            }
            @Override
            public StyleableProperty getStyleableProperty() {
               return DefinitionPane.StyleableProperties.GRID_LINES_VISIBLE;
            }
            @Override
            public Object getBean() {
               return DefinitionPane.this;
            }
            @Override
            public String getName() {
               return "gridLinesVisible";
            }
         };
      }

      return gridLinesVisible;
   }

   /**
    * Method description
    *
    *
    * @param priority
    * @param extraWidth
    *
    * @return
    */
   private double growOrShrinkColumnWidths(Priority priority, double extraWidth) {
      final boolean shrinking = extraWidth < 0;
      List<Integer> adjusting = new ArrayList<>();
      List<Integer> adjusted  = new ArrayList<>();

      for (int i = 0; i < columnWidths.length; i++) {
         if (shrinking) {
            adjusting.add(i);
         }
      }

      double  available       = extraWidth;    // will be negative in shrinking case
      boolean handleRemainder = false;
      int     portion         = 0;

      while ((available != 0) && (adjusting.size() > 0)) {
         if (!handleRemainder) {
            portion = (int) available / adjusting.size();    // negative in shrinking case
         }

         if (portion != 0) {
            for (int i = 0; i < adjusting.size(); i++) {
               final int    index = adjusting.get(i);
               final double limit = (shrinking
                                     ? columnMinWidth[index]
                                     : columnPrefWidth[index]) - columnWidths[index];    // negative in shrinking case
               final double change = (Math.abs(limit) <= Math.abs(portion))
                                     ? limit
                                     : portion;

               columnWidths[index] += change;

               // if (node.id.startsWith("debug.")) println("{if (shrinking) "vshrink" else "vgrow"}: {node.id} portion({portion})=available({available})/({sizeof adjusting}) change={change}");
               available -= change;

               if (Math.abs(change) < Math.abs(portion)) {
                  adjusted.add(index);
               }

               if (available == 0) {
                  break;
               }
            }

            for (int i = 0; i < adjusted.size(); i++) {
               adjusting.remove(adjusted.get(i));
            }

            adjusted.clear();
         } else {

            // Handle the remainder
            portion = (int) (available) % adjusting.size();

            if (portion == 0) {
               break;
            } else {

               // We have a remainder evenly distribute it.
               portion         = shrinking
                                 ? -1
                                 : 1;
               handleRemainder = true;
            }
         }
      }

      for (int i = 0; i < columnWidths.length; i++) {
         columnWidths[i] = snapSpace(columnWidths[i]);
      }

      return available;    // might be negative in shrinking case
   }

   /**
    * The width of the horizontal gaps between columns.
    *
    * @return
    */
   public final DoubleProperty hgapProperty() {
      if (hgap == null) {
         hgap = new StyleableDoubleProperty(0) {
            @Override
            public void invalidated() {
               requestLayout();
            }
            @Override
            public StyleableProperty getStyleableProperty() {
               return DefinitionPane.StyleableProperties.HGAP;
            }
            @Override
            public Object getBean() {
               return DefinitionPane.this;
            }
            @Override
            public String getName() {
               return "hgap";
            }
         };
      }

      return hgap;
   }


   /**
    * Method description
    *
    */
   @Override
   protected void layoutChildren() {
      performingLayout = true;
      final double snaphgap      = snapSpace(getHgap());
      final double snapvgap      = snapSpace(getVgap());
      final double top           = snapSpace(getInsets().getTop());
      final double bottom        = snapSpace(getInsets().getBottom());
      final double left          = snapSpace(getInsets().getLeft());
      final double right         = snapSpace(getInsets().getRight());
      final double width         = getWidth();
      final double height        = getHeight(); // When is height computed?
      final double contentHeight = height - top - bottom;
      final double contentWidth  = width - left - right;
      double       columnTotal   = 0;
      double       rowTotal      = 0;

      computeGridMetrics();

      Orientation contentBias = getContentBias();

      if (contentBias == null) {
         rowTotal    = adjustRowHeights(rowPrefHeight, height);
         columnTotal = adjustColumnWidths(columnPrefWidth, width);
      } else if (contentBias == Orientation.HORIZONTAL) {
         columnTotal = adjustColumnWidths(columnPrefWidth, width);
         computeRowMetrics(rowHeights.length, columnWidths);
         rowTotal = adjustRowHeights(rowPrefHeight, height);
      } else if (contentBias == Orientation.VERTICAL) {
         rowTotal = adjustRowHeights(rowPrefHeight, height);
         computeColumnMetrics(columnWidths.length, rowHeights);
         columnTotal = adjustColumnWidths(columnPrefWidth, width);
      }

      final double x = left + computeXOffset(contentWidth, columnTotal, getAlignment().getHpos());
      final double y = top + computeYOffset(contentHeight, rowTotal, getAlignment().getVpos());

      for (int i = 0; i < getChildren().size(); i++) {
         Node child = getChildren().get(i);

         if (child.isManaged()) {
            int rowIndex    = getNodeRowIndex(child);
            int columnIndex = getNodeColumnIndex(child);
            int colspan     = getNodeColumnSpan(child);

            if (colspan == REMAINING) {
               colspan = columnWidths.length - columnIndex;
            }

            int rowspan = getNodeRowSpan(child);

            if (rowspan == REMAINING) {
               rowspan = rowHeights.length - rowIndex;
            }

            double areaX = x;

            for (int j = 0; j < columnIndex; j++) {
               areaX += columnWidths[j] + snaphgap;
            }

            double areaY = y;

            for (int j = 0; j < rowIndex; j++) {
               areaY += rowHeights[j] + snapvgap;
            }

            double areaW = columnWidths[columnIndex];

            for (int j = 2; j <= colspan; j++) {
               areaW += columnWidths[columnIndex + j - 1] + snaphgap;
            }

            double areaH = rowHeights[rowIndex];

            for (int j = 2; j <= rowspan; j++) {
               areaH += rowHeights[rowIndex + j - 1] + snapvgap;
            }

            Insets margin = getMargin(child);

            //System.out.println("layoutNode("+child.toString()+" row/span="+rowIndex+"/"+rowspan+" col/span="+columnIndex+"/"+colspan+" area="+areaX+","+areaY+" "+areaW+"x"+areaH+""+" rowBaseline="+rowBaseline[rowIndex]);
            layoutInArea(child, areaX, areaY, areaW, areaH, rowBaseline[rowIndex], margin,
                         shouldColumnFillWidth(columnIndex), shouldRowFillHeight(rowIndex), HPos.LEFT, VPos.CENTER);
         }
      }
      edges.getChildren().clear();
      // Add edges here. 

      layoutGridLines(x, y, rowTotal, columnTotal);
      performingLayout = false;
   }

   /**
    * Method description
    *
    *
    * @param x
    * @param y
    * @param columnHeight
    * @param rowWidth
    */
   private void layoutGridLines(double x, double y, double columnHeight, double rowWidth) {
      if (!isGridLinesVisible()) {
         return;
      }

      if (!gridLines.getChildren().isEmpty()) {
         gridLines.getChildren().clear();
      }

      double hgap = snapSpace(getHgap());
      double vgap = snapSpace(getVgap());

      // create vertical lines
      double linex = x;
      double liney = y;

      for (int i = 0; i <= columnWidths.length; i++) {
         gridLines.getChildren().add(createGridLine(linex, liney, linex, liney + columnHeight));

         if ((i > 0) && (i < columnWidths.length) && (getHgap() != 0)) {
            linex += getHgap();
            gridLines.getChildren().add(createGridLine(linex, liney, linex, liney + columnHeight));
         }

         if (i < columnWidths.length) {
            linex += columnWidths[i];
         }
      }

      // create horizontal lines
      linex = x;

      for (int i = 0; i <= rowHeights.length; i++) {
         gridLines.getChildren().add(createGridLine(linex, liney, linex + rowWidth, liney));

         if ((i > 0) && (i < rowHeights.length) && (getVgap() != 0)) {
            liney += getVgap();
            gridLines.getChildren().add(createGridLine(linex, liney, linex + rowWidth, liney));
         }

         if (i < rowHeights.length) {
            liney += rowHeights[i];
         }
      }
   }

   /**
    * Method description
    *
    */
   @Override
   public void requestLayout() {

      // RT-18878: Do not update metrics dirty if we are performing layout.
      // If metricsDirty is set true during a layout pass the next call to computeGridMetrics()
      // will clear all the cell bounds resulting in out of date info until the
      // next layout pass.
      if (!metricsDirty &&!performingLayout) {
         metricsDirty = true;
      }

      super.requestLayout();
   }

   /**
    * Method description
    *
    *
    * @param part
    * @param definitionTree
    * @param partType
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    */
   private Node setupNode(DefinitionPart part, DefinitionTree definitionTree, DefinitionPartType partType)
           throws IOException, ContradictionException {
      Label partLabel = new Label(part.getText(definitionTree.getViewCoordinate()));

      setWidthAndStyleClass(partLabel, partType);

      return partLabel;
   }

   /**
    * Method description
    *
    *
    * @param part
    * @param definitionTree
    * @param partType
    * @param graphic
    *
    * @return
    *
    * @throws ContradictionException
    * @throws IOException
    */
   private Node setupNodeTextFromNid2(DefinitionPart part, DefinitionTree definitionTree,
                                      DefinitionPartType partType, Node graphic)
           throws IOException, ContradictionException {
      Label partLabel = new Label(part.getTextNid2(definitionTree.getViewCoordinate()), graphic);

      setWidthAndStyleClass(partLabel, partType);

      return partLabel;
   }

   /**
    * Method description
    *
    *
    * @param columnIndex
    *
    * @return
    */
   private boolean shouldColumnFillWidth(int columnIndex) {
      return true;
   }

   /**
    * Method description
    *
    *
    * @param rowIndex
    *
    * @return
    */
   private boolean shouldRowFillHeight(int rowIndex) {
      return true;
   }

   /**
    * Method description
    *
    *
    * @param value
    * @param snapToPixel
    *
    * @return
    */
   static double snapPosition(double value, boolean snapToPixel) {
      return snapToPixel
             ? Math.round(value)
             : value;
   }

   /**
    * Method description
    *
    *
    * @param value
    * @param snapToPixel
    *
    * @return
    */
   static double snapSize(double value, boolean snapToPixel) {
      return snapToPixel
             ? Math.ceil(value)
             : value;
   }

   /**
    * Method description
    *
    *
    * @param value
    * @param snapToPixel
    *
    * @return
    */
   static double snapSpace(double value, boolean snapToPixel) {
      return snapToPixel
             ? Math.round(value)
             : value;
   }

   /**
    * Method description
    *
    *
    * @param numbers
    *
    * @return
    */
   private static double sum(double[] numbers) {
      double total = 0;

      for (double n : numbers) {
         total += n;
      }

      return total;
   }

   /**
    * Returns a string representation of this {@code DefinitionPane} object.
    * @return a string representation of this {@code DefinitionPane} object.
    */
   @Override
   public String toString() {
      return "Grid hgap=" + getHgap() + ", vgap=" + getVgap() + ", alignment=" + getAlignment();
   }

   /**
    * The height of the vertical gaps between rows.
    *
    * @return
    */
   public final DoubleProperty vgapProperty() {
      if (vgap == null) {
         vgap = new StyleableDoubleProperty(0) {
            @Override
            public void invalidated() {
               requestLayout();
            }
            @Override
            public StyleableProperty getStyleableProperty() {
               return DefinitionPane.StyleableProperties.VGAP;
            }
            @Override
            public Object getBean() {
               return DefinitionPane.this;
            }
            @Override
            public String getName() {
               return "vgap";
            }
         };
      }

      return vgap;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public final Pos getAlignment() {
      return (alignment == null)
             ? Pos.TOP_LEFT
             : alignment.get();
   }

   /**
    * Method description
    *
    *
    * @param columnIndex
    *
    * @return
    */
   private HPos getColumnHalignment(int columnIndex) {
      return HPos.LEFT;
   }

   /**
    * Returns the child's column index constraint if set.
    * @param child the child node of a defpane
    * @return the column index for the child or null if no column index was set
    */
   private  static Integer getColumnIndex(Node child) {
      return (Integer) getConstraint(child, COLUMN_INDEX_CONSTRAINT);
   }

   /**
    * Returns the child's column-span constraint if set.
    * @param child the child node of a defpane
    * @return the column span for the child or null if no column span was set
    */
   private  static Integer getColumnSpan(Node child) {
      return (Integer) getConstraint(child, COLUMN_SPAN_CONSTRAINT);
   }


   /**
    * Method description
    *
    *
    * @param node
    * @param key
    *
    * @return
    */
   private static Object getConstraint(Node node, Object key) {
      if (node.hasProperties()) {
         Object value = node.getProperties().get(key);

         if (value != null) {
            return value;
         }
      }

      return null;
   }

   /**
    *
    * @return null unless one of its children has a content bias.
    */
   @Override
   public Orientation getContentBias() {
      for (int i = 0; i < getChildren().size(); i++) {
         Node child = getChildren().get(i);

         if (child.isManaged() && (child.getContentBias() != null)) {
            return child.getContentBias();
         }
      }

      return null;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   public DefinitionTree getDefinitionTree() {
      return definitionTree;
   }

   /**
    * Method description
    *
    *
    * @return
    */
   private  double getHgap() {
      return (hgap == null)
             ? 0
             : hgap.get();
   }

 
   /**
    * Returns the child's margin constraint if set.
    * @param child the child node of a defpane
    * @return the margin for the child or null if no margin was set
    */
   private  static Insets getMargin(Node child) {
      return (Insets) getConstraint(child, MARGIN_CONSTRAINT);
   }

   /**
    * Method description
    *
    *
    * @param content
    * @param margins
    *
    * @return
    */
   private static double getMaxAreaBaselineOffset(List<Node> content, Insets margins[]) {
      double max = 0;

      for (int i = 0; i < content.size(); i++) {
         Node   node   = content.get(i);
         Insets margin = (margins[i] != null)
                         ? margins[i]
                         : Insets.EMPTY;

         max = Math.max(max, ((margin != null)
                              ? margin.getTop()
                              : 0) + node.getBaselineOffset());
      }

      return max;
   }

   /* utility method for computing the max of children's min or pref heights, taking into account baseline alignment */



   /**
    * Method description
    *
    *
    * @param node
    *
    * @return
    */
   private static int getNodeColumnEnd(Node node) {
      int columnSpan = getNodeColumnSpan(node);

      return (columnSpan != REMAINING)
             ? getNodeColumnIndex(node) + columnSpan - 1
             : REMAINING;
   }

   /**
    * Method description
    *
    *
    * @param node
    *
    * @return
    */
   private static int getNodeColumnIndex(Node node) {
      Integer columnIndex = getColumnIndex(node);

      return (columnIndex != null)
             ? columnIndex
             : 0;
   }

   /**
    * Method description
    *
    *
    * @param node
    *
    * @return
    */
   private static int getNodeColumnSpan(Node node) {
      Integer colspan = getColumnSpan(node);

      return (colspan != null)
             ? colspan
             : 1;
   }


   /**
    * Method description
    *
    *
    * @param node
    *
    * @return
    */
   private static int getNodeRowEnd(Node node) {
      int rowSpan = getNodeRowSpan(node);

      return (rowSpan != REMAINING)
             ? getNodeRowIndex(node) + rowSpan - 1
             : REMAINING;
   }

   /**
    * Method description
    *
    *
    * @param node
    *
    * @return
    */
   private static int getNodeRowIndex(Node node) {
      Integer rowIndex = getRowIndex(node);

      return (rowIndex != null)
             ? rowIndex
             : 0;
   }

   /**
    * Method description
    *
    *
    * @param node
    *
    * @return
    */
   private static int getNodeRowSpan(Node node) {
      Integer rowspan = getRowSpan(node);

      return (rowspan != null)
             ? rowspan
             : 1;
   }


   /**
    * Returns the child's row index constraint if set.
    * @param child the child node of a defpane
    * @return the row index for the child or null if no row index was set
    */
   private  static Integer getRowIndex(Node child) {
      return (Integer) getConstraint(child, ROW_INDEX_CONSTRAINT);
   }

   /**
    * Returns the child's row-span constraint if set.
    * @param child the child node of a defpane
    * @return the row span for the child or null if no row span was set
    */
   private  static Integer getRowSpan(Node child) {
      return (Integer) getConstraint(child, ROW_SPAN_CONSTRAINT);
   }


   /**
    * Method description
    *
    *
    * @return
    */
   private  double getVgap() {
      return (vgap == null)
             ? 0
             : vgap.get();
   }

   /**
    * Method description
    *
    *
    * @return
    */
   private  boolean isGridLinesVisible() {
      return (gridLinesVisible == null)
             ? false
             : gridLinesVisible.get();
   }

   /**
    * Sets the column index for the child when contained by a defpane
    * so that it will be positioned starting in that column of the defpane.
    * If a defpane child has no column index set, it will be positioned in
    * the first column.
    * Setting the value to null will remove the constraint.
    * @param child the child node of a defpane
    * @param value the column index of the child
    */
   private  static void setColumnIndex(Node child, Integer value) {
      if ((value != null) && (value < 0)) {
         throw new IllegalArgumentException("columnIndex must be greater or equal to 0, but was " + value);
      }

      setConstraint(child, COLUMN_INDEX_CONSTRAINT, value);
   }

   /**
    * Sets the column span for the child when contained by a defpane
    * so that it will span that number of columns horizontally.   This may be
    * set to REMAINING, which will cause the span to extend across all the remaining
    * columns.
    * <p>
    * If a defpane child has no column span set, it will default to spanning one column.
    * Setting the value to null will remove the constraint.
    * @param child the child node of a defpane
    * @param value the column span of the child
    */
   private  static void setColumnSpan(Node child, Integer value) {
      if ((value != null) && (value < 1)) {
         throw new IllegalArgumentException("columnSpan must be greater or equal to 1, but was " + value);
      }

      setConstraint(child, COLUMN_SPAN_CONSTRAINT, value);
   }

   /**
    * Method description
    *
    *
    * @param node
    * @param key
    * @param value
    */
   private static void setConstraint(Node node, Object key, Object value) {
      if (value == null) {
         node.getProperties().remove(key);
      } else {
         node.getProperties().put(key, value);
      }

      if (node.getParent() != null) {
         node.getParent().requestLayout();
      }
   }

   /**
    * Sets the column,row indeces for the child when contained in a defpane.
    * @param child the child node of a defpane
    * @param columnIndex the column index position for the child
    * @param rowIndex the row index position for the child
    */
   private  static void setConstraints(Node child, int columnIndex, int rowIndex) {
      setRowIndex(child, rowIndex);
      setColumnIndex(child, columnIndex);
   }


   /**
    * Sets the grid position, spans, and alignment for the child when contained in a defpane.
    * @param child the child node of a defpane
    * @param columnIndex the column index position for the child
    * @param rowIndex the row index position for the child
    * @param columnspan the number of columns the child should span
    * @param rowspan the number of rows the child should span
    * @param halignment the horizontal alignment of the child
    * @param valignment the vertical alignment of the child
    * @param hgrow the horizontal grow priority of the child
    * @param vgrow the vertical grow priority of the child
    */
   private  static void setConstraints(Node child, int columnIndex, int rowIndex, int columnspan, int rowspan,
                                     HPos halignment, VPos valignment) {
      setRowIndex(child, rowIndex);
      setColumnIndex(child, columnIndex);
      setRowSpan(child, rowspan);
      setColumnSpan(child, columnspan);
      setHalignment(child, halignment);
      setValignment(child, valignment);
   }

   /**
    * Method description
    *
    *
    * @param definitionTree
    *
    * @throws ContradictionException
    * @throws IOException
    */
   public void setDefinitionTree(DefinitionTree definitionTree) throws ContradictionException, IOException {
      this.definitionTree = definitionTree;
      this.getChildren().clear();
      this.edges.getChildren().clear();
      this.getChildren().add(this.edges);
      for (DefinitionPart part : definitionTree.getParts()) {
         if (part.getColumnIndex() > 1) {
            Node               node;
            DefinitionPartType partType = part.getPartType(definitionTree.getViewCoordinate());

            switch (partType) {
            case CONCEPT_REFERENCE_DEFINED :
               node = setupNode(part, definitionTree, partType);

               break;

            case CONCEPT_REFERENCE_PRIMITIVE :
               node = setupNode(part, definitionTree, partType);

               break;

            case AND :
               node = setupNode(part, definitionTree, partType);

               break;

            case DEFINITION_ROOT :
               node = setupNode(part, definitionTree, partType);

               break;

            case DISJOINT_WITH :
               node = setupNode(part, definitionTree, partType);

               break;

            case EDGE_FALSE :
               node = setupNode(part, definitionTree, partType);

               break;

            case EDGE_TRUE :
               node = setupNode(part, definitionTree, partType);

               break;

            case EXISTENTIAL_RESTRICTION :
               node = setupNodeTextFromNid2(
                  part, definitionTree, partType,
                  (Node) FXMLLoader.load(getClass().getResource("/fxml/ExistentialRestriction.fxml")));

               break;

            case FEATURE_FLOAT :
               node = setupNode(part, definitionTree, partType);

               break;

            case FEATURE_INT :
               node = setupNode(part, definitionTree, partType);

               break;

            case FEATURE_LONG :
               node = setupNode(part, definitionTree, partType);

               break;

            case FIELD_SUBSTITUTION :
               node = setupNode(part, definitionTree, partType);

               break;

            case NECESSARY_SET :
               node = FXMLLoader.load(getClass().getResource("/fxml/NecessarySet.fxml"));

               break;

            case OR :
               node = setupNode(part, definitionTree, partType);

               break;

            case SUFFICIENT_SET :
               node = FXMLLoader.load(getClass().getResource("/fxml/SufficientSet.fxml"));

               break;

            case TEMPLATE_MERGE :
               node = setupNode(part, definitionTree, partType);

               break;

            case UNIVERSAL_RESTRICTION :
               node = setupNodeTextFromNid2(
                  part, definitionTree, partType,
                  (Node) FXMLLoader.load(getClass().getResource("/fxml/ExistentialRestriction.fxml")));

               break;

            case ROLE_GROUP :
               node = FXMLLoader.load(getClass().getResource("/fxml/RoleGroup.fxml"));

               break;

            default :
               node = new Label(part.getText(definitionTree.getViewCoordinate()));
            }

            DefinitionPane.setConstraints(node, part.getColumnIndex(), part.getRowIndex(),
                                    partType.getColumnSpan(), 1, HPos.LEFT, VPos.CENTER);
            this.add(node, part.getColumnIndex(), part.getRowIndex());
         }
      }

      System.out.println("DefinitionPane->setDefinitionTree");
   }

   /**
    * Sets the horizontal alignment for the child when contained by a defpane.
    * If set, will override the defpane's default horizontal alignment.
    * Setting the value to null will remove the constraint.
    * @param child the child node of a defpane
    * @param value the hozizontal alignment for the child
    */
   private  static void setHalignment(Node child, HPos value) {
      setConstraint(child, HALIGNMENT_CONSTRAINT, value);
   }

   /**
    * Sets the margin for the child when contained by a defpane.
    * If set, the defpane will lay it out with the margin space around it.
    * Setting the value to null will remove the constraint.
    * @param child the child node of a defpane
    * @param value the margin of space around the child
    */
   private  static void setMargin(Node child, Insets value) {
      setConstraint(child, MARGIN_CONSTRAINT, value);
   }

   /**
    * Sets the row index for the child when contained by a defpane
    * so that it will be positioned starting in that row of the defpane.
    * If a defpane child has no row index set, it will be positioned in the
    * first row.
    * Setting the value to null will remove the constraint.
    * @param child the child node of a defpane
    * @param value the row index of the child
    */
   private  static void setRowIndex(Node child, Integer value) {
      if ((value != null) && (value < 0)) {
         throw new IllegalArgumentException("rowIndex must be greater or equal to 0, but was " + value);
      }

      setConstraint(child, ROW_INDEX_CONSTRAINT, value);
   }

   /**
    * Sets the row span for the child when contained by a defpane
    * so that it will span that number of rows vertically.  This may be
    * set to REMAINING, which will cause the span to extend across all the remaining
    * rows.
    * <p>
    * If a defpane child has no row span set, it will default to spanning one row.
    * Setting the value to null will remove the constraint.
    * @param child the child node of a defpane
    * @param value the row span of the child
    */
   private  static void setRowSpan(Node child, Integer value) {
      if ((value != null) && (value < 1)) {
         throw new IllegalArgumentException("rowSpan must be greater or equal to 1, but was " + value);
      }

      setConstraint(child, ROW_SPAN_CONSTRAINT, value);
   }

   /**
    * Sets the vertical alignment for the child when contained by a defpane.
    * If set, will override the defpane's default vertical alignment.
    * Setting the value to null will remove the constraint.
    * @param child the child node of a defpane
    * @param value the vertical alignment for the child
    */
   public static void setValignment(Node child, VPos value) {
      setConstraint(child, VALIGNMENT_CONSTRAINT, value);
   }

   /**
    * Method description
    *
    *
    * @param value
    */
   public final void setVgap(double value) {
      vgapProperty().set(value);
   }
private static Insets standardInset = new Insets(2,0,2,0);
   /**
    * Method description
    *
    *
    * @param partLabel
    * @param partType
    */
   private void setWidthAndStyleClass(Label partLabel, DefinitionPartType partType) {
      partLabel.setMaxWidth(NODE_WIDTH);
      partLabel.getStyleClass().add(partType.getCssStyleClass());
      setMargin(partLabel, standardInset);
   }

   /**
    *                                                                         
    *                         Stylesheet Handling                             
    *                                                                         
    */

   /**
    * Super-lazy instantiation pattern from Bill Pugh.
    * @treatAsPrivate implementation detail
    */
   private static class StyleableProperties {

      /** Field description */
      private static final StyleableProperty<DefinitionPane, Boolean> GRID_LINES_VISIBLE =
         new StyleableProperty<DefinitionPane, Boolean>("-fx-grid-lines-visible", BooleanConverter.getInstance(),
                               Boolean.FALSE) {
         @Override
         public boolean isSettable(DefinitionPane node) {
            return (node.gridLinesVisibleProperty() == null) ||!node.gridLinesVisibleProperty().isBound();
         }
         @Override
         public WritableValue<Boolean> getWritableValue(DefinitionPane node) {
            return node.gridLinesVisibleProperty();
         }
      };

      /** Field description */
      private static final StyleableProperty<DefinitionPane, Number> HGAP = new StyleableProperty<DefinitionPane,
                                                                         Number>("-fx-hgap",
                                                                            SizeConverter.getInstance(),
                                                                            0.0) {
         @Override
         public boolean isSettable(DefinitionPane node) {
            return (node.hgapProperty() == null) ||!node.hgapProperty().isBound();
         }
         @Override
         public WritableValue<Number> getWritableValue(DefinitionPane node) {
            return node.hgapProperty();
         }
      };

      /** Field description */
      private static final StyleableProperty<DefinitionPane, Pos> ALIGNMENT =
         new StyleableProperty<DefinitionPane, Pos>("-fx-alignment", new EnumConverter<Pos>(Pos.class),
                               Pos.TOP_LEFT) {
         @Override
         public boolean isSettable(DefinitionPane node) {
            return (node.alignmentProperty() == null) ||!node.alignmentProperty().isBound();
         }
         @Override
         public WritableValue<Pos> getWritableValue(DefinitionPane node) {
            return node.alignmentProperty();
         }
      };

      /** Field description */
      private static final StyleableProperty<DefinitionPane, Number> VGAP = new StyleableProperty<DefinitionPane,
                                                                         Number>("-fx-vgap",
                                                                            SizeConverter.getInstance(),
                                                                            0.0) {
         @Override
         public boolean isSettable(DefinitionPane node) {
            return (node.vgapProperty() == null) ||!node.vgapProperty().isBound();
         }
         @Override
         public WritableValue<Number> getWritableValue(DefinitionPane node) {
            return node.vgapProperty();
         }
      };

      /** Field description */
      private static final List<StyleableProperty> STYLEABLES;

      static {
         final List<StyleableProperty> styleables =
            new ArrayList<>(Region.impl_CSS_STYLEABLES());

         Collections.addAll(styleables, GRID_LINES_VISIBLE, HGAP, ALIGNMENT, VGAP);
         STYLEABLES = Collections.unmodifiableList(styleables);
      }
   }
}
