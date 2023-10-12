# Pipeline_System
This Project is a Pipeline Management System which is implemented using Graph Data Structure.
Output - 
Enter the no. of places:9
Enter the name of the place: bavdhan
Enter the name of the place: baner
Enter the name of the place: khadki
Enter the name of the place: vimannagar
Enter the name of the place: kothrud
Enter the name of the place: swargate
Enter the name of the place: dhankawadi
Enter the name of the place: kondhwa
Enter the name of the place: katraj

Enter the no. of connecting paths:16
Enter source place name: bavdhan
Enter destination place name: baner
Enter the distance between them(in kms): 7.9
Enter source place name: baner
Enter destination place name: khadki
Enter the distance between them(in kms): 9.7
Enter source place name: khadki
Enter destination place name: vimannagar
Enter the distance between them(in kms): 9
Enter source place name: bavdhan
Enter destination place name: kothrud
Enter the distance between them(in kms): 4.2
Enter source place name: baner
Enter destination place name: kothrud
Enter the distance between them(in kms): 12.2
Enter source place name: baner
Enter destination place name: swargate
Enter the distance between them(in kms): 11.7
Enter source place name: khadki
Enter destination place name: swargate
Enter the distance between them(in kms): 8.7
Enter source place name: vimannagar
Enter destination place name: swargate
Enter the distance between them(in kms): 12.4
Enter source place name: kothrud
Enter destination place name: swargate
Enter the distance between them(in kms): 7
Enter source place name: kothrud
Enter destination place name: dhankawadi
Enter the distance between them(in kms): 13.8
Enter source place name: swargate
Enter destination place name: kondhwa
Enter the distance between them(in kms): 6.6
Enter source place name: kothrud
Enter destination place name: kondhwa
Enter the distance between them(in kms): 13.3
Enter source place name: swargate
Enter destination place name: dhankawadi
Enter the distance between them(in kms): 5
Enter source place name: dhankawadi
Enter destination place name: kondhwa
Enter the distance between them(in kms): 5.7
Enter source place name: dhankawadi
Enter destination place name: katraj
Enter the distance between them(in kms): 2.7
Enter source place name: kondhwa
Enter destination place name: katraj
Enter the distance between them(in kms): 4.6


Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
1
0.0  7.9  0.0  0.0  4.2  0.0  0.0  0.0  0.0
7.9  0.0  9.7  0.0  12.2  11.7  0.0  0.0  0.0
0.0  9.7  0.0  9.0  0.0  8.7  0.0  0.0  0.0
0.0  0.0  9.0  0.0  0.0  12.4  0.0  0.0  0.0
4.2  12.2  0.0  0.0  0.0  7.0  13.8  13.3  0.0
0.0  11.7  8.7  12.4  7.0  0.0  5.0  6.6  0.0
0.0  0.0  0.0  0.0  13.8  5.0  0.0  5.7  2.7
0.0  0.0  0.0  0.0  13.3  6.6  5.7  0.0  4.6
0.0  0.0  0.0  0.0  0.0  0.0  2.7  4.6  0.0

Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
2
dhankawadi-->katraj
bavdhan-->kothrud
swargate-->dhankawadi
kondhwa-->katraj
bavdhan-->baner
kothrud-->swargate
baner-->khadki
khadki-->vimannagar
Total length of obtained network: 50.1

Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
3
Enter the purpose of the pipeline:
1 for drinking water
2 for irrigation water
3 for CNG
4 for LPG
5 for crude oil
4
Copper pipeline will be used. The total cost will be Rs.: 6012000.0
The per kilometer price will be Rs.: 120000

Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
3
Enter the purpose of the pipeline:
1 for drinking water
2 for irrigation water
3 for CNG
4 for LPG
5 for crude oil
3
Black steel pipeline will be used. The total cost will be Rs.: 2004000.0
The per kilometer price will be Rs.: 40000

Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
3
Enter the purpose of the pipeline:
1 for drinking water
2 for irrigation water
3 for CNG
4 for LPG
5 for crude oil
1
PVC pipe will be used. The total cost will be Rs.: 7515000.0
The per kilometer price will be Rs.: 150000

Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
4
Enter the source place:
katraj
Minimum distance to place bavdhan is 18.9.
Minimum distance to place baner is 19.4.
Minimum distance to place khadki is 16.4.
Minimum distance to place vimannagar is 20.099998.
Minimum distance to place kothrud is 14.7.
Minimum distance to place swargate is 7.7.
Minimum distance to place dhankawadi is 2.7.
Minimum distance to place kondhwa is 4.6.
Minimum distance to place katraj is 0.0.


Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
4
Enter the source place:
baner
Minimum distance to place bavdhan is 7.9.
Minimum distance to place baner is 0.0.
Minimum distance to place khadki is 9.7.
Minimum distance to place vimannagar is 18.7.
Minimum distance to place kothrud is 12.1.
Minimum distance to place swargate is 11.7.
Minimum distance to place dhankawadi is 16.7.
Minimum distance to place kondhwa is 18.3.
Minimum distance to place katraj is 19.400002.


Enter:
1 to display the adjacency matrix of the layout
2 to see the optimised pipeline layout
3 to see the cost of the obtained layout
4 to get the shortest distance between a source place and any other place
0 to exit
0
Exited.

Process finished with exit code 0
