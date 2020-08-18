package by.chernyavski.repository.vote;

import by.chernyavski.model.Vote;
import by.chernyavski.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DataJpaVoteRepository implements VoteRepository {

    private final CrudVoteRepository voteRepository;

    public DataJpaVoteRepository(CrudVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public boolean delete(int id) {
        return voteRepository.delete(id) != 0;
    }

    @Override
    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        return voteRepository.getAllByDate(date);
    }

    @Override
    public List<Vote> getAllByDateWithRest(LocalDate date) {
        return voteRepository.getAllByDateWithRest(date);
    }
}
