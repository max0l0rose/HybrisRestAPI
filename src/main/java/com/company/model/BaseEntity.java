package com.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

//@Entity // ERROR
//@Inheritance(strategy = InheritanceType.JOINED)
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable
										//implements StringsArray
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequenceGen")
	//@JsonProperty
//	@GeneratedValue(generator = "idSequence")
//	@SequenceGenerator(//schema = "MYORASCHEMA",
//			name = "idSequence",
//			sequenceName = "MY_ORACLE_SEQ_NAME",
//			allocationSize = 1)

	//@Column(name="id")
	//@Basic
	long id;

	@Column(columnDefinition = "integer default 0")
	@JsonIgnore // works!
	int version;

	//@Temporal(TemporalType.TIMESTAMP) // ERROR
	@Column(name = "created_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",
			updatable = false, insertable = false)
	//@CreationTimestamp // hibernate
	//@Transient
	Instant created;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
			updatable = false, insertable = false)
	//@Temporal(TemporalType.TIMESTAMP) // ERROR
	//@UpdateTimestamp // hibernate
	Instant modified; //LocalDateTime


//	public String[] toStringsArray() {
//		return new String[] {String.valueOf(id), String.valueOf(created), String.valueOf(modified)};
//	}

//	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//	OffsetDateTime created_offsetDT;


//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//String cname = getClass().getName(); // norm
//	String oname = o.getClass().getName();
	//		if (o == null || getClass() != o.getClass()) return false;
//
//		BaseEntity that = (BaseEntity) o;
//
//		//if (version != that.version) return false;
//		if (!Objects.equals(id, that.id))
//			return false;
//		//if (created != null ? !created.equals(that.created) : that.created != null) return false;
//		return true;//modified != null ? modified.equals(that.modified) : that.modified == null;
//	}
//
	@Override
	public int hashCode() {
		//int result = id != null ? Objects.hashCode(id) : 0;
		int result = (int)id;//Objects.hashCode(id);
		//result = 31 * result + version;
		//result = 31 * result + (created != null ? created.hashCode() : 0);
		//result = 31 * result + (modified != null ? modified.hashCode() : 0);
		return result;
	}
}
