function [all_theta] = oneVsAll(X, y, num_labels, lambda)

% Some useful variables
m = size(X, 1);
n = size(X, 2);

all_theta = zeros(num_labels, n + 1);

% Add ones to the X data matrix
X = [ones(m, 1) X];

	for c = 1:num_labels,
		initial_theta = zeros(n+1,1);
		options = optimset('GradObj', 'on', 'MaxIter', 50);
		all_theta(c,:) = (fmincg(@(t)(lrCostFunction(t,X, (y==c), lambda)), initial_theta, options));
	end

% =========================================================================


end
