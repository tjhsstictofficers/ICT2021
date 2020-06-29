// Written by Justin Choi / Daniel Zeng

#include <bits/stdc++.h>
using namespace std;
 
typedef long long ll;
 
int vis[1000][1000][5][2];
deque<vector<int>> bfs;
char gr[1000][1000];
int n, m;
 
int search(int r, int c){
  bfs.push_back({r, c, 0, 0, 0}); // r, c, dir, force, dist
  while(bfs.size()){
    auto t = bfs.front(); bfs.pop_front();
    int r = t[0], c = t[1], d = t[2], f = t[3], l = t[4];
    if(vis[r][c][d][f]) continue;
    vis[r][c][d][f] = 1;
    if(gr[r][c] == 'E') return l;
    if(gr[r][c] == 'S') f = 1;
    if((r+1 >= n || gr[r+1][c] == '#') && d == 2) f = 0;
    if((c+1 >= m || gr[r][c+1] == '#') && d == 1) f = 0;
    if((!r || gr[r-1][c] == '#') && d == 4) f = 0;
    if((!c || gr[r][c-1] == '#') && d == 3) f = 0;
    if(f){
      if(d == 1) bfs.push_back({r, c+1, 1, 1, l+1});
      if(d == 2) bfs.push_back({r+1, c, 2, 1, l+1});
      if(d == 3) bfs.push_back({r, c-1, 3, 1, l+1});
      if(d == 4) bfs.push_back({r-1, c, 4, 1, l+1});
    }else{
      if(r+1 < n && gr[r+1][c] != '#') bfs.push_back({r+1, c, 2, 0, l+1});
      if(c+1 < m && gr[r][c+1] != '#') bfs.push_back({r, c+1, 1, 0, l+1});
      if(r && gr[r-1][c] != '#') bfs.push_back({r-1, c, 4, 0, l+1});
      if(c && gr[r][c-1] != '#') bfs.push_back({r, c-1, 3, 0, l+1});
    }
  }
  return -1;
}
 
int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m;
  for(int i = 0; i < n; i ++) for(int j = 0; j < m; j ++) cin >> gr[i][j];
  for(int i = 0; i < n; i ++) for(int j = 0; j < m; j ++) if(gr[i][j] == 'A'){
    cout << search(i, j) << endl;
    return 0;
  }
}