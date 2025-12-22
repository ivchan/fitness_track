package homelab.ftrack.service;

import java.util.List;

import homelab.ftrack.dto.DailySummaryCreateDto;
import homelab.ftrack.dto.DailySummarySearchDto;
import homelab.ftrack.model.DailyMeal;
import homelab.ftrack.model.DailySummary;

public interface DailySummaryService {
  DailySummary createDailySummary(DailySummaryCreateDto dto);

  DailySummary getDailySummary(String id);

  void removeDailySummary(String id);

  List<DailySummary> listDailySummary(DailySummarySearchDto searchCond);

  DailyMeal addMeal();

  void removeMeal(String id);
}
