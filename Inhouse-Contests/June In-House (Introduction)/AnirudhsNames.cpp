#include "bits/stdc++.h"
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);

    int n;
    cin >> n;

    int numAarav = 0;
    for (int i = 0; i < n ; i++)
    {
        string name;
        cin >> name;
        if (name == "aarav")
            numAarav++;
    }

    if (numAarav > 0)
        cout << numAarav;
    else
        cout << "SAD ANI";

    return 0;
}