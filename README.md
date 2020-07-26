# Project-on-a-sovereign-or-semi-sovereign-Identity-Manage-ment-System-in-a-centralized-manner-with-en
This Project is to investigate on data structures and algorithms for identity management with an emphasis on privacy and anonymity.

Identity management is an emerging area of research and market either in
the web2 or web3 context.
Ultimately, they pursue a sovereign ID management such that
each individual user manages and controls their ID information and data
in a decentralized manner ideally.

However, in this project, an attempt will be made to experiment on
a sovereign or semi-sovereign ID management in a centralized manner.

# Input:

user's first name, last name, age, gender, primary language,
SNS login ID, email, roles, services, groups, permissions.

# Output:
1. A privacy graph (make it to be both BFS with an arbitrary source and DFS traversable)
2. An anonymity graph
3. All-in-one graph dual-graph, one for users and another for groups on top of the users-graph)
4. Strongly-trusted(untrusted)-components
5. Shortest-trusted-path (single-source single-destination, etc)
6. Minimum-trust-spanning-tree
7. Mamximum-trust-flow

Each node represents a user or a group such that a multilayered graph is
constructed, one for users and another for groups and each user may belong to
none or one or multi groups.

There are various edges except the inter layer crossing edges such as
first-name-edge, last-name-edge, age-edge, gender-edge, primary-language-edge,
SNS-login-ID-edge, email-edge, roles-edge, services-edge, groups-edge,
permissions-edge. Further, each edge can be declared either
Private (or Public), or Anonymous (or Identified), namely PPAI.
For instance, a first-name-edge is drawn from user A to user B
as declared private, means user A wants to decalre his (her) first name private
(i.e., hidden) from user B, or vice versa, and likewise an extensive PPAI relationships among
users and groups and etc can be explored.
