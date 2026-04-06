Project Proposal: Improving Autonomous Navigation Using Sensor Fusion
Overview
This project aims to investigate methods for improving the accuracy and stability of autonomous robot navigation by combining multiple sensor sources and applying filtering techniques. Autonomous robots frequently rely on odometry, inertial measurements, and computer vision to estimate their position within an environment. However, each of these sources contains noise and uncertainty, which can lead to navigation errors and unstable motion.
The primary goal of this project is to explore how filtering and sensor fusion techniques can improve navigation performance. Specifically, the robot will combine odometry and vision data using filters such as low-pass filters and Kalman filters to produce smoother and more accurate position estimates.
The robot will be built using FTC-compatible components and will be capable of autonomously navigating through a structured environment such as a maze or waypoint course. Experimental trials will compare navigation accuracy and stability under different filtering approaches.

Research Question
The main research question for this project is:
How does filtering and sensor fusion of odometry and vision data affect the stability and accuracy of autonomous navigation?
More specifically:
Can filtering reduce noise and oscillations in robot movement?


Does combining vision data with odometry significantly improve navigation accuracy?


Which filtering techniques produce the most stable navigation behavior?



Project Goals
The primary goals of the project are:
Build a small autonomous robot platform capable of navigating an environment using mecanum wheels.


Implement position estimation using odometry and vision sensors.


Apply filtering techniques to smooth noisy sensor data.


Fuse multiple sensor sources to improve navigation accuracy.


Evaluate the effectiveness of different filtering approaches through controlled experiments.


Document the entire process in a structured report and open-source repository.



Hardware Platform
The robot will be built using components commonly used in FTC robotics.
Planned hardware components:
FTC Control Hub


Mecanum wheel drivetrain


Motor encoders for odometry


IMU (inertial measurement unit)


Camera for computer vision


Optional AprilTag markers for position reference


The robot will use odometry and vision to estimate its position and navigate toward target waypoints.

Software and Algorithms
Several control and filtering techniques will be explored in this project.
Navigation and Motion Control
The robot will navigate using waypoint-based motion control.
Controllers that may be implemented include:
PID controllers


PIDF controllers


motion profiling


feedforward control


These control methods determine how the robot adjusts its movement in response to position error.

Sensor Filtering
Sensor measurements often contain noise. Several filtering methods will be explored to smooth the data.
Low-Pass Filtering
Low-pass filters reduce high-frequency noise in sensor measurements, producing smoother data for control algorithms.
Kalman Filtering
Kalman filters provide a probabilistic approach to sensor fusion. The filter predicts the robot’s state using motion estimates and corrects this prediction using measurement updates from vision sensors.
In this project:
Odometry will be used for prediction


Vision measurements (such as AprilTags) will be used for correction


This allows the robot to maintain reasonable position estimates even when vision measurements are temporarily unavailable.

Experimental Design
To evaluate the effectiveness of different filtering techniques, the robot will perform repeated navigation trials in a controlled environment.
Test Environment
The robot will navigate through a predefined course such as:
a maze


a waypoint path


an obstacle course


Markers or reference points may be placed in the environment to provide vision-based corrections.

Navigation Methods to Compare
Several navigation methods will be tested and compared.
Raw odometry only


Odometry with low-pass filtering


Odometry with vision correction


Sensor fusion using a Kalman filter



Evaluation Metrics
Performance will be measured using the following metrics:
final position error


path deviation from planned trajectory


motion smoothness


oscillation or jitter near targets


time required to reach goals


Multiple trials will be conducted for each method to ensure reliable results.

Project Timeline
Phase 1 – Research and Background Study
Study the following topics:
sensor fusion


Kalman filters


low-pass filters


control theory and PID controllers


computer vision for robotics


Deliverable: background research summary.

Phase 2 – Hardware Development
Design and assemble the robot platform.
Tasks include:
mechanical design


CAD modeling


fabrication and assembly


sensor integration


Deliverable: functional robot hardware platform.

Phase 3 – Baseline Navigation
Implement core navigation functionality:
odometry tracking


waypoint navigation


basic PID control


Deliverable: robot capable of navigating between target coordinates.

Phase 4 – Filtering Implementation
Implement filtering methods and sensor fusion techniques.
Tasks include:
low-pass filtering of sensor data


Kalman filter implementation


integration of vision-based corrections


Deliverable: multiple navigation modes with different filtering strategies.

Phase 5 – Experimental Testing
Run repeated navigation trials and collect data.
Tasks include:
performing multiple test runs


recording position error


analyzing trajectory data


Deliverable: dataset of experimental results.

Phase 6 – Analysis and Documentation
Analyze the results and prepare documentation.
Tasks include:
generating graphs and charts


comparing filtering techniques


writing conclusions and future improvements


Deliverable: final project report and presentation.

Documentation and Repository
All work will be documented in a public GitHub repository.
The repository will include:
source code


hardware designs


experimental data


weekly progress reports


final project documentation


Example structure:
autonomous-navigation-research

README.md

docs
proposal.md
weekly_reports.md
final_report.md

code
navigation
filters
vision

data
experiment_results

cad
robot_design

Mentorship and Weekly Meetings
To improve the credibility and quality of the project, the goal is to work with a mentor such as a robotics or control systems professor.
Weekly meetings will include:
presenting project progress


discussing challenges and design decisions


receiving technical guidance


After each meeting, a short progress report will be written summarizing:
goals for the week


accomplishments


problems encountered


plans for the next week



Expected Outcomes
By the end of the project, the following outcomes are expected:
A fully functioning autonomous robot capable of navigating using filtered sensor fusion.


Experimental evidence comparing different filtering techniques.


A comprehensive report describing the design, implementation, and results.


A well-documented open-source repository.


A presentation summarizing the project findings.
