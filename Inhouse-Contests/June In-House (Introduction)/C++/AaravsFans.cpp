#include "bits/stdc++.h"
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);

    int N, Q;
    cin >> N >> Q;

    int p[3][100005];
    for (int i = 1; i <= N; i++)
    {
        int type;
        cin >> type;
        for (int j = 0; j < 3; j++)
            p[j][i] = p[j][i - 1] + (j == type - 1 ? 1 : 0);
    }

    for (int i = 0; i < Q; i++)
    {
        int l, r;
        cin >> l >> r;
        cout << p[0][r] - p[0][l - 1] << " " << p[1][r] - p[1][l - 1] << " " << p[2][r] - p[2][l - 1] << "\n";
    }

    return 0;
}