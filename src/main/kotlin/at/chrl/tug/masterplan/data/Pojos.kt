package at.chrl.tug.masterplan.data

import java.util.*
import javax.persistence.*

/**
 * Created by ChRL on 24.02.16.
 * Project: masterplan
 * Package: at.chrl.tug.masterplan.data
 * <p>
 * <br>
 */
@Entity
data class Lecture(
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
        val id: Long = 0,
        val lectureNumber: Int = 0,
        val title: String = "",
        val hours: Double = 0.0,
        val ects: Double = 0.0,
        @Enumerated(javax.persistence.EnumType.STRING)
        val type: LectureType = LectureType.VO,
        @Enumerated(javax.persistence.EnumType.STRING)
        val compulsoryTypes: CompulsoryType = CompulsoryType.FREE
){}

@Entity
data class Equivalent(
        @Id
        @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
        val id: Long = 0,
        @OneToOne
        val l1: Lecture? = null,
        @OneToOne
        val l2: Lecture? = null
){}

enum class LectureType{
    VO, KU, UE, VU, SE, SP, PR, LU
}

enum class CompulsoryType{
    FREE, ELECTIVE, COMPULSORY
}

enum class Catalogue(val title: String){
    C01("Secure and Correct Systems"),
    C02("Computer Vision and Graphics"),
    C03("Robotics and Computational Intelligence"),
    C04("Signal Processing and Human Communication"),
    C05("Communications and Mobile Computing"),
    C06("Embedded and Automotive Systems"),
    C07("Measurement and Control Systems"),
    C08("Microelectronics and IC Design"),
    S01("Supplementary Catalogue"),
    B01("Business, Law, and Management")
}
