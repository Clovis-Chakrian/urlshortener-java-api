package br.com.clovischakrian.urlshortener.repositories;

import br.com.clovischakrian.urlshortener.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
    public Optional<Link> getByLinkId(int linkId);

    @Query("select l from links l")
    public List<Link> getAll();
}
