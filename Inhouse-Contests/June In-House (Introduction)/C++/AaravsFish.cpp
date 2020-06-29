#include "bits/stdc++.h"
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);

    int M, N;
    cin >> M >> N;

    int freq[1000005];
    for (int i = 0; i < M; i++)
    {
        int color;
        cin >> color;
        freq[color - 1]++;
    }

    int csize = M / N, numDec = 0, numInc = 0;
    for (int i = 0; i < N; i++)
    {
        if (freq[i] < csize)
            numInc += csize - freq[i];
        else if (freq[i] > csize + 1)
            numDec += freq[i] - (csize + 1);
    }

    cout << max(numInc, numDec) << '\n';

    return 0;
}