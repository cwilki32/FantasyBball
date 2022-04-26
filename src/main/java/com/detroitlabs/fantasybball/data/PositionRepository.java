package com.detroitlabs.fantasybball.data;

import com.detroitlabs.fantasybball.model.Position;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PositionRepository {

}


    /*used to categorize players by position to restrict lineup eligibility, lineups will have

    2g, 2f, 2c, 2util*/

//    private static final List<Position> ALL_POSITIONS = Arrays.asList(
//            new Position("G", "Guard"),
//            new Position("F", "Forward"),
//            new Position("C", "Center"),
//            new Position("G||F||C", "Utility")
//    );
//
//    public List<Position> getAllPositions() {
//        return ALL_POSITIONS;
//    }
//
//    public Position findByPosition(String pos) {
//        for (Position position: ALL_POSITIONS) {
//            if(position.getPosition().equals(position)) {
//                return position;
//            }
//        } return null;
//    }
//
//}
