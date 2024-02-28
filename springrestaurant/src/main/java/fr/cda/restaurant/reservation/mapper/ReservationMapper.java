package fr.cda.restaurant.reservation.mapper;

import fr.cda.restaurant.reservation.Reservation;
import fr.cda.restaurant.reservation.dto.ReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public class ReservationMapper {
        ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

        ReservationDto toRerservation(Reservation reservation);

        List<ReservationDto> toReservation(List<Reservation> reservation);

    }


