package it.eforhum.corsojava.cap2.annotation.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import it.eforhum.corsojava.cap2.annotation.annotation.FormatoData;
import it.eforhum.corsojava.cap2.annotation.annotation.PrintableFields;

public class EventoSistema implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrintableFields(header = "ID", lenght = 10)
	private Integer id;

	@PrintableFields(header = "Descrizione", lenght = 16)
	private String descrizione;

	@PrintableFields(header = "Data", lenght = 11)
	@FormatoData(formato = "dd/MM/yyyy")
	private LocalDate data;

	@PrintableFields(header = "CreationUser", lenght = 15)
	private String creationUser;

	@PrintableFields(header = "CreationTime", lenght = 15)
	private LocalDateTime creationTime;

	@PrintableFields(header = "UpdateUser", lenght = 15)
	private String updateUser;

	@PrintableFields(header = "UpdateTime", lenght = 15)
	private LocalDateTime updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EventoSistema [id=" + id + ", descrizione=" + descrizione + ", data=" + data + ", creationUser="
				+ creationUser + ", creationTime=" + creationTime + ", updateUser=" + updateUser + ", updateTime="
				+ updateTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationTime, creationUser, data, descrizione, id, updateTime, updateUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoSistema other = (EventoSistema) obj;
		return Objects.equals(creationTime, other.creationTime) && Objects.equals(creationUser, other.creationUser)
				&& Objects.equals(data, other.data) && Objects.equals(descrizione, other.descrizione)
				&& Objects.equals(id, other.id) && Objects.equals(updateTime, other.updateTime)
				&& Objects.equals(updateUser, other.updateUser);
	}

}
