
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.ihtsdo.ttk.pl.fx.helper;

//~--- non-JDK imports --------------------------------------------------------

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import org.ihtsdo.ttk.fx.concept.FxConcept;
import org.ihtsdo.ttk.fx.fetchpolicy.RefexPolicy;
import org.ihtsdo.ttk.fx.fetchpolicy.RelationshipPolicy;
import org.ihtsdo.ttk.fx.fetchpolicy.VersionPolicy;

//~--- JDK imports ------------------------------------------------------------

import java.util.UUID;

/**
 *
 * @author kec
 */
public class GetConceptService extends Service<FxConcept> {
   private VersionPolicy      versionPolicy      = VersionPolicy.ALL_VERSIONS;
   private RefexPolicy        refexPolicy        = RefexPolicy.REFEX_MEMBERS;
   private RelationshipPolicy relationshipPolicy =
      RelationshipPolicy.ORIGINATING_AND_DESTINATION_RELATIONSHIPS;
   private UUID conceptUuid;
   private UUID viewCoordinateUuid;

   @Override
   protected Task<FxConcept> createTask() {
      return new GetConceptTask(conceptUuid, versionPolicy, refexPolicy, relationshipPolicy,
                                viewCoordinateUuid);
   }

   public UUID getConceptUuid() {
      return conceptUuid;
   }

   public RefexPolicy getRefexPolicy() {
      return refexPolicy;
   }

   public RelationshipPolicy getRelationshipPolicy() {
      return relationshipPolicy;
   }

   public VersionPolicy getVersionPolicy() {
      return versionPolicy;
   }

   public UUID getViewCoordinateUuid() {
      return viewCoordinateUuid;
   }

   public void setConceptUuid(UUID conceptUuid) {
      this.conceptUuid = conceptUuid;
   }

   public void setRefexPolicy(RefexPolicy refexPolicy) {
      this.refexPolicy = refexPolicy;
   }

   public void setRelationshipPolicy(RelationshipPolicy relationshipPolicy) {
      this.relationshipPolicy = relationshipPolicy;
   }

   public void setVersionPolicy(VersionPolicy versionPolicy) {
      this.versionPolicy = versionPolicy;
   }

   public void setViewCoordinateUuid(UUID viewCoordinateUuid) {
      this.viewCoordinateUuid = viewCoordinateUuid;
   }
}
