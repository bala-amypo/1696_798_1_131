@Service
public class SupplyForecastServiceImpl implements SupplyForecastService {

    @Autowired
    private SupplyForecastRepository repository;

    @Override
    public SupplyForecast save(SupplyForecast forecast) {
        return repository.save(forecast);
    }

    @Override
    public SupplyForecast update(Long id, SupplyForecast forecast) {
        forecast.setId(id);
        return repository.save(forecast);
    }

    @Override
    public Optional<SupplyForecast> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public SupplyForecast getLatest() {
        return repository.findTopByOrderByForecastTimeDesc();
    }

    @Override
    public List<SupplyForecast> getAll() {
        return repository.findAll();
    }
}
