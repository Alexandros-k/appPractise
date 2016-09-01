
Description of the project
  
  this is a jdbc app for allowing medical visitors of a medical company control their visits.its allows them to do the following :

1.	Let a user log in to the system, either as administrator or as medical visitor.

2.	Allow an administrator to assign visitors to known doctors to the system; at any given time, a doctor may have zero or at most one visitors assigned to them.

3.	Allow an administrator to create new cycle of scheduled visits to a list of selected (default: all) doctors the system knows about from each currently assigned visitor.

4.	Allow visitors to enter information about new doctors to the system: the following information must be recorded when entering a new doctor: name, specialty (selected from a list), address, phone, city (selected from a list), geographic area (selected from a list), institution (selected from a list), position; when the doctor’s data are entered, the system first checks to verify that the doctor’s name and address are unique in the system, and then automatically assigns a unique id to the doctor, and also assigns the visitor who entered the doctor’s data to that doctor.

5.	Allow visitors to search for doctors, and see and edit information about any doctor they are currently assigned to in the system (see figure 1), but not delete doctors.

6.	Allow visitors to enter information about a visit they paid to a doctor; the information should contain the visitor’s id, the doctor’s id, the date of the visit and any optional comments about the visit.

7.	Allow visitors to see the information they have entered about visits for the current cycle.

8.	Allow administrator to delete a doctor from the system.
