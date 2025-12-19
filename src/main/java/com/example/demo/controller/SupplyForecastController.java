@RestController
@RequestMapping("/api/supply-forecasts")
public class SupplyForecastController {

    private final SupplyForecastService service;

    public SupplyForecastController(SupplyForecastService service) {
        this.service = service;
    }

    @PostMapping
    public SupplyForecast create(@RequestBody SupplyForecast forecast) {
        return service.createForecast(forecast);
    }

    @PutMapping("/{id}")
    public SupplyForecast update(@PathVariable Long id,
                                 @RequestBody SupplyForecast forecast) {
        return service.updateForecast(id, forecast);
    }

    @GetMapping("/{id}")
    public SupplyForecast get(@PathVariable Long id) {
        return service.getForecastById(id);
    }

    @GetMapping("/latest")
    public SupplyForecast latest() {
        return service.getLatestForecast();
    }

    @GetMapping
    public List<SupplyForecast> all() {
        return service.getAllForecasts();
    }
}
