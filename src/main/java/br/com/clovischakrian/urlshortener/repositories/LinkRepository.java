package br.com.clovischakrian.urlshortener.repositories;

import br.com.clovischakrian.urlshortener.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Integer> {
    public Optional<Link> getByLinkId(int linkId);

    @Query("select * from links")
    public List<Link> getAll();
}
