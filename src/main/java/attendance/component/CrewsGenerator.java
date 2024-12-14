package attendance.component;

import attendance.domain.Crew;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CrewsGenerator {
    private static final String CREWS_PATH = "src/main/resources/attendances.csv";
    private static final int TABLE_HEADER_ROW_INDEX = 0;
    private static final String CREWS_DELIMITER = ",";
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
    private final FileParser fileParser;

    public CrewsGenerator(final FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public List<Crew> generate() {
        List<String> crewTexts = getCrewsTexts();
        List<Crew> crews = parseCrews(crewTexts);
        parseAttendances(crewTexts, crews);
        return crews;
    }

    private List<String> getCrewsTexts() {
        List<String> crewTexts = fileParser.parse(CREWS_PATH);
        removeCrewsTextsHeader(crewTexts);
        return crewTexts;
    }

    private void removeCrewsTextsHeader(final List<String> crewTexts) {
        crewTexts.remove(TABLE_HEADER_ROW_INDEX);
    }

    private List<Crew> parseCrews(final List<String> crewTexts) {
        return crewTexts.stream()
                .map(this::parseCrew)
                .distinct()
                .collect(Collectors.toList());
    }

    private Crew parseCrew(final String crewText) {
        String[] crewData = crewText.split(CREWS_DELIMITER);
        return Crew.from(crewData[0]);
    }

    private void parseAttendances(final List<String> crewTexts, final List<Crew> crews) {
        crewTexts.forEach(crewText -> parseAttendance(crewText, crews));
    }

    private void parseAttendance(final String crewText, final List<Crew> crews) {
        String[] crewData = crewText.split(CREWS_DELIMITER);
        Crew crew = getCrewByName(crewData[0], crews);
        crew.additionAttendances(parseLocalDateTime(crewData[1]));
    }

    private LocalDateTime parseLocalDateTime(final String localDateTime) {
        return LocalDateTime.parse(localDateTime, DATE_TIME_FORMATTER);
    }

    private Crew getCrewByName(final String name, final List<Crew> crews) {
        return crews.stream()
                .filter(crew -> crew.matchName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
