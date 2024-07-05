package one_to_many_delete_cascade;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student2 {
private long studentId;
private String studentName;
private Set<Phone2> studentPhoneNumbers;
public Student2() {
}
public Student2(String studentName, Set<Phone2> studentPhoneNumbers) {
this.studentName = studentName;
this.studentPhoneNumbers = studentPhoneNumbers;
}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "STUDENT_ID")
public long getStudentId() {
return this.studentId;
}
public void setStudentId(long studentId) {
this.studentId = studentId;
}
@Column(name = "STUDENT_NAME", nullable = false, length = 100)
public String getStudentName() {
return this.studentName;
}
public void setStudentName(String studentName) {
this.studentName = studentName;
}

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name = "sid", referencedColumnName="STUDENT_ID")
public Set<Phone2> getStudentPhoneNumbers() {
return this.studentPhoneNumbers;
}
public void setStudentPhoneNumbers(Set<Phone2> studentPhoneNumbers) {
this.studentPhoneNumbers = studentPhoneNumbers;
}
}