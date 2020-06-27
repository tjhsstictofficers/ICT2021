#include "bits/stdc++.h"
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    bool containsM = false;
    int numLessM = 0, numM = 0, numGreaterM = 0;

    for (int i = 0; i < N; i++)
    {
        int ai;
        cin >> ai;
        containsM |= ai == M;

        if (ai == M)
            numM++;
        else if (ai < M)
            numLessM++;
        else
            numGreaterM++;
    }

    int numToAdd = 0;
    int l = numLessM + 1, r = numLessM + numM;

    if (!containsM)
    {
        numToAdd++; N++; r++;
    }

    while ((N + 1) / 2 < l || r < (N + 1) / 2)
    {
        N++; r++; numToAdd++;
    }

    cout << numToAdd << '\n';

    return 0;
}   