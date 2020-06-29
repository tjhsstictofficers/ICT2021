#include "bits/stdc++.h"
using namespace std;

#define f first
#define s second
int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);

    int W, N;
    cin >> W >> N;

    vector<int> p1, p2, p3;
    int nump1 = 0, nump2 = 0, nump3 = 0;

    for (int i = 0; i < N; i++)
    {
        int wi, pi;
        cin >> wi >> pi;
        if (pi == 1)
        {
            p1.push_back(wi);
            nump1++;
        }
        else if (pi == 2)
        {
            p2.push_back(wi);
            nump2++;
        }
        else
        {
            p3.push_back(wi);
            nump3++;
        }
    }

    int trips = 0;
    int cur = 0;
    int i1 = 0, i2 = 0, i3 = 0;
    for (int i = 0; i < N; i++)
    {
        int w;
        if (i1 < nump1)
            w = p1[i1++];
        else if (i2 < nump2)
            w = p2[i2++];
        else
            w = p3[i3++];

        if (cur + w > W)
        {
            trips++;
            cur = 0;
        }
        cur += w;
    }

    if (cur)
        trips++;

    cout << trips << '\n';

    return 0;
}