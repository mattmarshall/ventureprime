package me.gotdo.vp3.web.model;

public class DocumentMeta {
	
	public static final long DEFAULT_SCHEMA_VERSION = 0;
	
	public static final long DEFAULT_DOCUMENT_VERSION = 0;
	
	private long schemaVersion;
	
	private long documentVersion;
	
	public DocumentMeta() {
		schemaVersion = DEFAULT_SCHEMA_VERSION;
		documentVersion = DEFAULT_DOCUMENT_VERSION;
	}

	public DocumentMeta(long schemaVersion, long documentVersion) {
		this.schemaVersion = schemaVersion;
		this.documentVersion = documentVersion;
	}

	public long getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(long schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	public long getDocumentVersion() {
		return documentVersion;
	}

	public void setDocumentVersion(long documentVersion) {
		this.documentVersion = documentVersion;
	}

}
