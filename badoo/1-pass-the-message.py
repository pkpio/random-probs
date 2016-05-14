from common import *
import networkx as nx

T = readInt()

for _ in range(T):
    N = readInt()
    FG = nx.DiGraph()

    for i in range(1,N+1):
        ci = readIntArr()
        FG.add_edges_from([(i,x) for x in ci])

    if not nx.is_connected(FG.to_undirected()):
        writeLine(0)
        continue

    lens = nx.all_pairs_shortest_path_length(FG)
    c,mn = [0],[100]
    for i,friend in enumerate(lens):
        mx = lens[friend][max(lens[friend], key=lens[friend].get)]
        if mx < mn[0]:
            mn.clear()
            c.clear()
            mn.append(mx)
            c.append(i+1)
        elif mx <= mn[0]:
            mn.append(mx)
            c.append(i+1)
    writeLine(' '.join(str(i) for i in sorted(c)))


