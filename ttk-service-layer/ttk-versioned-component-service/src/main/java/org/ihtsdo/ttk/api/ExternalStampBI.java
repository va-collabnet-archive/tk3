package org.ihtsdo.ttk.api;

import java.util.UUID;

public interface ExternalStampBI {

    UUID getStatusUuid();
    long getTime();
    UUID getAuthorUuid();
    UUID getModuleUuid();
    UUID getPathUuid();


}