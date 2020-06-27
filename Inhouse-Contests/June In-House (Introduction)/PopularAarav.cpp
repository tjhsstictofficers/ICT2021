#include "bits/stdc++.h"
using namespace std;

int N;
vector<int> graph[100005];
bool isGirl[100005], visited[100005];

int dfs(int v, bool good)
{
    int insecurity = good ? 0 : (isGirl[v] ? 1 : 2);
    visited[v] = true;
    for (auto &u : graph[v])
        if (!visited[u])
            insecurity += dfs(u, (isGirl[v] || v == 0) ? good : false);
    return insecurity;
}

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);

    cin >> N;
    for (int i = 0; i < N; i++) cin >> isGirl[i];

    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        graph[a - 1].push_back(b - 1);
        graph[b - 1].push_back(a - 1);
    }

    cout << dfs(0, true);

    return 0;
}