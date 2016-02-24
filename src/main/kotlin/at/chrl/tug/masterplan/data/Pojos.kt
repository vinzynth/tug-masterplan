package at.chrl.tug.masterplan.data

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
        val id: Long,
        val lectureNumber: Int,
        val title: String,
        val hours: Double,
        val ects: Double,
        @Enumerated(javax.persistence.EnumType.STRING)
        val type: LectureType,
        @ElementCollection
        @Enumerated(javax.persistence.EnumType.STRING)
        val compulsoryTypes: List<CompulsoryType>
){}

enum class LectureType{
    VO, KU, UE, VU, SE, SP, PR, LU
}

enum class CompulsoryType{
    FREE, ELECTIVE, COMPULSORY
}

enum class Catalogue(val title: String){
    c01("Secure and Correct Systems"),
    c02("Computer Vision and Graphics"),
    c03("Robotics and Computational Intelligence"),
    c04("Signal Processing and Human Communication"),
    c05("Communications and Mobile Computing"),
    c06("Embedded and Automotive Systems"),
    c07("Measurement and Control Systems"),
    c08("Microelectronics and IC Design"),
    s01("Supplementary catalogue"),
    b01("Business, Law, and Management")
}
