/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int pascal(int n, int r) {
    int resultelement = 1; 
    for (int i = 0; i < r; i++) {
        resultelement *= (n - i);
        resultelement /= (i + 1);
    }
    return resultelement;
}

int** generate(int numRows, int* returnSize, int** returnColumnSizes) {
    *returnColumnSizes = malloc(numRows * sizeof(int));
    int **result = malloc(numRows * sizeof(int*));  // allocate row pointers

    for (int i = 0; i < numRows; i++) {
        (*returnColumnSizes)[i] = i + 1;            // set column size
        result[i] = malloc((i + 1) * sizeof(int));  // allocate each row
        for (int j = 0; j <= i; j++) {              
            result[i][j] = pascal(i, j);
        }
    }

    *returnSize = numRows;
    return result;
}

