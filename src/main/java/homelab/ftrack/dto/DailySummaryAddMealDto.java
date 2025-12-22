package homelab.ftrack.dto;

public class DailySummaryAddMealDto {
  private String id;
  private String summaryId;
  private String mealId;
  private int qty;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSummaryId() {
    return summaryId;
  }

  public void setSummaryId(String summaryId) {
    this.summaryId = summaryId;
  }

  public String getMealId() {
    return mealId;
  }

  public void setMealId(String mealId) {
    this.mealId = mealId;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

}
