@RestController
@RequestMapping("/api/load-shedding")
public class LoadSheddingController {

    private final LoadSheddingService service;

    public LoadSheddingController(LoadSheddingService service) {
        this.service = service;
    }

    @PostMapping("/trigger/{forecastId}")
    public LoadSheddingEvent trigger(@PathVariable Long forecastId) {
        return service.triggerLoadShedding(forecastId);
    }

    @GetMapping("/{id}")
    public LoadSheddingEvent get(@PathVariable Long id) {
        return service.getEventById(id);
    }

    @GetMapping("/zone/{zoneId}")
    public List<LoadSheddingEvent> byZone(@PathVariable Long zoneId) {
        return service.getEventsForZone(zoneId);
    }

    @GetMapping
    public List<LoadSheddingEvent> all() {
        return service.getAllEvents();
    }
}
