# JAVA application 1
A plot is a label, which is created with a given one-letter label and background color
(Color). The label is printed in white (WHITE) and Serif font, bold, size 14.
The background color of the plot can be changed. A plot can be selected by clicking the mouse, which it
reports to the parent container.
• The grassy surface is a plot of green color (GREEN) and
marks ".
• The water surface is a plot of light blue color (CYAN) and
marks ~.
• A battery has an integer amount of current energy i
set maximum capacity. During the creation of the battery is
completely full. It is possible to add a given integer
the amount of energy in the battery, whereby the excess energy
discards after the battery is fully charged. Possible
is to completely drain the battery. It can be checked whether
the battery is full.
• A producer is a parcel that actively produces energy in
cycles. It is created with an additionally specified integer
basic time and battery. Total time
production is calculated as the sum of the base time and a randomly generated integer in the range [0,
300]. The manufacturer periodically waits the total time, then produces a certain number of units
of energy with which it charges the battery (with possible production failure) and additionally waits for 300
milliseconds. If the producer has successfully produced energy, his name is printed
in red color (RED) during the specified interval of 300 milliseconds, after the current production,
and before the new production cycle. It is possible to stop the manufacturer.
• The hydroelectric plant is a producer of blue color (BLUE) and the mark H. It can be assigned a number
of water bodies surrounding it (at creation 0). The hydroelectric power plant generates in each
cycle, one unit of energy for each water surface that surrounds it. Energy production
is successful if the hydropower plant is surrounded by at least one water surface. Basic time
production is 1500 milliseconds.
• The plot is a grid of plots. It is created with the given number of grid rows and columns. On occasion
of creation each field of the grid is randomly initialized with grass (probability 70%) or
water surface (probability 30%). One plot can be selected. By choosing a new plot,
the previously selected lot is de-selected. The font size is increased for the selected parcel
on 20. It is possible to add a producer to the selected plot, after which the hydroelectric power plants
updates the number of water bodies surrounding them. If no plot is selected,
adding manufacturer failed. It is possible to stop the work of all manufacturers.
• The power system is the main application window 500 pixels wide and 500 pixels high that contains
plot and battery. It is created with the given number of rows and columns of the board and the battery capacity. U
during the creation of the energy system, a plot and a battery were created. Unable to resize
windows. The window contains a button for adding a new manufacturer.
