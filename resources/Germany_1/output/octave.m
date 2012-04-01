%% Machine Learning, FootballGame Prediction

%% Initialization
clear ; close all; clc

%% Setup the parameters you will use for this part of the exercise
input_layer_size  = 13;  % 20x20 Input Images of Digits
num_labels = 3;          % 10 labels, from 1 to 10   
                          % (note that we have mapped "0" to label 10)
my_result = [];

%% =========== Part 1: Loading and Visualizing Data =============
%  We start the exercise by first loading and visualizing the dataset. 
%  You will be working with a dataset that contains handwritten digits.
%

% Load Training Data
fprintf('Loading and Visualizing Data ...\n')

%X = load('D1_onlyWithBWIN_fromFifth.csv'); % 50.74
%X = load('D1_onlyWithBwin.csv'); % 50.5
%X = load('D1_withoutBWIN.csv'); % 49.11
%X = load('D1_allSince1991.csv');%49.38
%X = load('D1_try2_fromFifth_withBWIN.csv'); %with last 5 and last 3 games -> 68 %
X = load('D1_try2_fromFifth_withLast5_withBWIN.csv');

y = X(:,size(X,2));
X = X(:, [1 2 3 4 5 6 7 8 9 10 11 12 13]);

%load('D1_onlyWithBWIN_fromFifth.csv'); % training data stored in arrays X, y
m = size(X, 1);

fprintf('\nTraining One-vs-All Logistic Regression...\n')

lambda = 0.1;
[all_theta] = oneVsAll(X, y, num_labels, lambda);

fprintf('Program paused. Press enter to continue.\n');
pause;


%% ================ Part 3: Predict for One-Vs-All ================
%  After ...
pred = predictOneVsAll(all_theta, X);

fprintf('\nTraining Set Accuracy: %f\n', mean(double(pred == y)) * 100);

% calculating the win/loos
ones = ((pred==1)==y) .* X(:, 11);
twos = ((pred==2)==y) .* X(:, 13);

[ones twos];

result= sum(ones + twos -1)

%quotes = [(1==y) ]

save predicted_values.dat pred;
save all_theta.dat all_theta;
save result.dat my_result;

all_theta

