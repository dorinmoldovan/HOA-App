# HOA-App

A Java implementation of the HOA.

## Using HOA-App

1. Clone the current repository locally.
2. Run the App.java class.

## Objective Functions for HOA-App Evaluation

$$OF_1 = \sum_{i=1}^{N}x_i^2, [-100, 100]$$

$$OF_2 = \sum_{i = 1}^{N} i \times x_i^4 + random[0, 1), [-1.28, 1.28]$$

$$OF_3 = max(\left| x_i\right|, 1 \le i \le N), [-100, 100]$$

$$OF_4 = \sum_{i = 1}^{N - 1} \left[ 100 \times \left(x_{i + 1} - x_i^2 \right)^2 + \left( x_i - 1 \right)^2 \right], [-30, 30]$$

$$OF_5 = \sum_{i = 1}^{N} \left[ x_i^2 - 10 \times cos (2 \pi x_i) + 10 \right], [-5.12, 5.12]$$

$$OF_6 = \sum_{i = 1}^{N} \left| x_i \right| + \prod_{i = 1}^{N} \left| x_i \right|, [-10, 10]$$

$$OF_7 = \frac{1}{4000} \times \sum_{i = 1}^{N} x_i^2 - \prod_{i = 1}^{N} cos \left( \frac{x_i}{\sqrt{i}} \right) + 1, [-600, 600]$$

$$OF_8 = \sum_{i=1}^{N} \left( \sum_{j = 1}^{i} x_j \right)^2, [-100, 100]$$

$$OF_9 = \frac{1}{2000} \times \sum_{i = 1}^{N} x_i^2 - \prod_{i = 1}^{N} cos^{4} \left( \frac{x_i^2}{i} \right) + 1, [-300, 300]$$

## HOA-App Use Case

HOA-App for OF1.

![HOA-App Snapshot](hoa_app_snapshot.PNG?raw=true "Title")

## Author

Dorin Moldovan

## Research Articles

[1] Moldovan, D. (2020). Horse Optimization Algorithm: A Novel Bio-Inspired Algorithm for Solving Global Optimization Problems, Silhavy, R. (eds) Artificial Intelligence and Bioinspired Computational Methods. CSOC 2020. Advances in Intelligent Systems and Computing, vol 1225. Springer, Cham. [[CrossRef](https://link.springer.com/chapter/10.1007/978-3-030-51971-1_16)]

[2] Moldovan, D. (2021). Improved Kangaroo Mob Optimization and Logistic Regression for Smart Grid Stability Classification. In: Silhavy, R. (eds) Artificial Intelligence in Intelligent Systems. CSOC 2021. Lecture Notes in Networks and Systems, vol 229. Springer, Cham. [[CrossRef](https://link.springer.com/chapter/10.1007/978-3-030-77445-5_44)]

[3] Moldovan, D. (2022). Binary Horse Optimization Algorithm for Feature Selection. Algorithms, 15, 156. Multidisciplinary Digital Publishing Institute, Basel, Switzerland. [[CrossRef](https://www.mdpi.com/1999-4893/15/5/156)]