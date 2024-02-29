package fr.cda.restaurant.reservation.mapper;

import fr.cda.restaurant.reservation.Reservation;
import fr.cda.restaurant.reservation.dto.ReservationCompletDto;
import fr.cda.restaurant.reservation.dto.ReservationReduitDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    public fr.cda.restaurant.reservation.mapper.ReservationMapper INSTANCE = Mappers.getMapper(fr.cda.restaurant.reservation.mapper.ReservationMapper.class);

    public ReservationCompletDto toReservationComplet(Reservation reservation);

    public List<ReservationCompletDto> toReservationComplet (List<Reservation> reservations);
    public ReservationReduitDto toReservationReduit(Reservation reservation);

    public List<ReservationReduitDto> toReservationReduit (List<Reservation> reservations);
}
