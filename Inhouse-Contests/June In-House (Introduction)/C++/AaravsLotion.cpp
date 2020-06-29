#include "bits/stdc++.h"
using namespace std;

int N, L;
int a[100005];

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);

    cin >> N >> L;

    for (int i = 0; i < N; i++) cin >> a[i];

    sort(a, a + N);

    int maxDif = a[0] - 0;
    for (int i = 1; i < N; i++)
        maxDif = max(maxDif, a[i] - a[i - 1]);
    maxDif = max(maxDif, L - a[N - 1]);

    cout << (maxDif / 2) + (maxDif % 2) << "\n";

    return 0;
}