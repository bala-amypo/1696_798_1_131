@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @PostMapping("/")
    public Zone create(@RequestBody Zone zone) {
        return zoneService.save(zone);
    }

    @PutMapping("/{id}")
    public Zone update(@PathVariable Long id, @RequestBody Zone zone) {
        return zoneService.update(id, zone);
    }

    @GetMapping("/{id}")
    public Optional<Zone> getById(@PathVariable Long id) {
        return zoneService.getById(id);
    }

    @GetMapping("/")
    public List<Zone> getAll() {
        return zoneService.getAll();
    }

    @PostMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        return zoneService.deactivate(id);
    }
}
