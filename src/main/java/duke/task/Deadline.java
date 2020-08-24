package duke.task;

import duke.exception.WrongFormatException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDate date;
    protected LocalDateTime dateAndTime;

    public Deadline(String description, String by) throws WrongFormatException {
        super(description, "[D]", "deadline", false);
        String[] bySplit = by.split(" ");
        String byDate = bySplit[0];
        String byTime = bySplit[1];
        this.date = LocalDate.parse(byDate);
        this.dateAndTime = this.date.atTime(Integer.parseInt(byTime.substring(0,2)),
                Integer.parseInt(byTime.substring(2,4)));
    }

    public Deadline(String description, String by, boolean isDone) throws WrongFormatException {
        super(description, "[D]", "deadline", isDone);
        String[] bySplit = by.split(" ");
        String byDate = bySplit[0];
        String byTime = bySplit[1];
        this.date = LocalDate.parse(byDate);
        this.dateAndTime = this.date.atTime(Integer.parseInt(byTime.substring(0,2)),
                Integer.parseInt(byTime.substring(2,4)));
    }

    @Override
    public String stringToSaveInMemory() {
        return super.stringToSaveInMemory() + "|" + dateAndTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + dateAndTime.format(DateTimeFormatter.ofPattern("d MMM yyyy @ hh:mma"))
                + ")";
    }
}