@Repository
public interface DemandReadingRepository
        extends JpaRepository<DemandReading, Long> {

    DemandReading findTopByZoneIdOrderByRecordedAtDesc(Long zoneId);

    List<DemandReading> findByZoneIdOrderByRecordedAtDesc(Long zoneId);
}
