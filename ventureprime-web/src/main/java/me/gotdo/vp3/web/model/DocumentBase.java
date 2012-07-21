package me.gotdo.vp3.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public abstract class DocumentBase<E> {
	
	@Id
	private String id;
	
	@Indexed
	private DocumentMeta metadata;
	
	protected DocumentBase() {
		metadata = new DocumentMeta();
	}
	
	protected DocumentBase(String id, DocumentMeta metadata) {
		this.id = id;
		this.metadata = metadata;		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public DocumentMeta getMetadata() {
		return metadata;
	}
	
	public void setMetadata(DocumentMeta metadata) {
		this.metadata = metadata;
	}
	
	public abstract DocumentBase<E> upgradeTo(long newVersion);
}
