package com.reto.mudanzas.mapper;

import com.reto.mudanzas.domain.Competitor;
import com.reto.mudanzas.domain.dto.CompetitorDTO;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CompetitorMapper {

    public CompetitorDTO toCompetitorDTO(Competitor competitor);

    public Competitor toCompetitor(CompetitorDTO competitorDTO);

    public List<CompetitorDTO> toCompetitorsDTO(List<Competitor> competitors);

    public List<Competitor> toCompetitors(List<CompetitorDTO> CompetitorsDTO);
}
