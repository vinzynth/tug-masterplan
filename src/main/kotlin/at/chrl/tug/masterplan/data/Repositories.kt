package at.chrl.tug.masterplan.data

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

/**
 * Created by ChRL on 24.02.16.
 * Project: masterplan
 * Package: at.chrl.tug.masterplan.data
 * <p>
 * <br>
 */
@Repository
interface LectureRepository : PagingAndSortingRepository<Lecture, Long> {
}

@Repository
interface EquivalentRepository : PagingAndSortingRepository<Equivalent, Long> {
}
