package by.chernyavski.repository;

import by.chernyavski.model.User;
import by.chernyavski.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VoteRepository {

    Vote save(Vote vote);

    boolean delete(int id);

    List<Vote> getAll();

    List<Vote> getAllByDate(LocalDate dateTime);

    List<Vote> getAllByDateWithRest(LocalDate dateTime);

    Vote getVoteByDateAndUser(LocalDate date, User user);
}
