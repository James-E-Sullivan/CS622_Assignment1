Boston Parcel Search (BPS)

What is BPS?
This project is an application that receives user input regarding the type of land or building the user wants to buy in 
Boston, and it returns relevant parcel information. The program reads 2016 parcel/assessment data from the City of 
Boston, which is stored in a CSV file. The user will be able to set parameters for their search, land-use, parcel ID, 
and address. BPS will search for parcels that match user parameters, filter Parcel objects by property value, write
parcel information to a text file, write Parcel objects to a .dat file, and display matching parcel information to 
the console. BPS will cross-reference parcels (from the search output) with parcels within a csv file to check if a 
package is being delivered to that parcel’s address. Parcel and Package I/O will be performed concurrently.

How to run the program:

    * Run src/Concurrency/Concurrent_CSV_Input
    * Follow console commands
    
Where are the input and IO files located?:

    * I/O files are located in the resources folder