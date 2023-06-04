package hr.app.business.model.dto;


public class StatisticsDTO {
	private String type;
	private long typeTotal;
	
    public StatisticsDTO(String type, Long typeTotal) {
        this.type = type;
        this.typeTotal = typeTotal;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getTypeTotal() {
		return typeTotal;
	}

	public void setTypeTotal(long typeTotal) {
		this.typeTotal = typeTotal;
	}
    
    
}
