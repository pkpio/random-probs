from common import *
import networkx as nx

T = readInt()

for _ in range(T):
    N = readInt()
    FG = nx.DiGraph()

    for i in range(1,N+1):
        ci = readIntArr()
        FG.add_edges_from([(i,x) for x in ci])
    print(FG.edges())


