#include <bits/stdc++.h>
using namespace std;

void solve() {
    int m, s, c;
    cin >> m >> s >> c;
    bool stalls[s];
    for (int i = 0; i < s; i++)
        stalls[i] = false;
    for (int i = 0; i < c; i++) {
        int stall;
        cin >> stall;
        stall--;
        stalls[stall] = true;
    }
    int n = 0;
    int i = 0;

    while (i < s && !stalls[i]) {
        i++;
        n++;
    }
    int begin = i;
    i = s - 1;
    while (i >= 0 && !stalls[i]) {
        i--;
        n++;
    }
    int end = i;
    vector<int> runs;
    bool flag = false;
    int cur = 0;
    for (i = begin; i <= end; i++) {
        if (stalls[i] && flag) {
            runs.push_back(cur);
            cur = 0;
            flag = !flag;
        } else if (!stalls[i] && !flag) {
            cur = 1;
            flag = !flag;
        } else if (!stalls[i] && flag)
            cur++;
    }

    sort(runs.rbegin(), runs.rend());
    int size = runs.size();
    for (i = 0; i < min(m - 1, size); i++)
        n += runs[i];
    cout << s - n << "\n";


}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    solve();
    return 0;
}