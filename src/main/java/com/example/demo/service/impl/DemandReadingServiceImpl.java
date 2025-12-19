@Service
public class DemandReadingServiceImpl implements DemandReadingService {

    private final DemandReadingRepository repository;

    public DemandReadingServiceImpl(DemandReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public DemandReading createReading(DemandReading reading) {
        return repository.save(reading);
    }

    @Override
    public DemandReading getLatestReading(Long zoneId) {
        return repository.findFirstByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public List<DemandReading> getReadingsForZone(Long zoneId) {
        return repository.findByZoneIdOrderByRecordedAtDesc(zoneId);
    }

    @Override
    public List<DemandReading> getRecentReadings(Long zoneId, int limit) {
        return getReadingsForZone(zoneId).stream().limit(limit).toList();
    }
}
