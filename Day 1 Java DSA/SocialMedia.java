public class SocialMedia {
    class User {
        int userId;
        String name;
        int age;
        FriendNode friends;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = null;
            this.next = null;
        }
    }

    class FriendNode {
        int friendId;
        FriendNode next;

        FriendNode(int friendId) {
            this.friendId = friendId;
            this.next = null;
        }
    }

    private User head;

    public SocialMedia() {
        this.head = null;
    }

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public User findUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            FriendNode newFriend1 = new FriendNode(userId2);
            newFriend1.next = user1.friends;
            user1.friends = newFriend1;

            FriendNode newFriend2 = new FriendNode(userId1);
            newFriend2.next = user2.friends;
            user2.friends = newFriend2;
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            removeFriendFromUser(user1, userId2);
            removeFriendFromUser(user2, userId1);
        }
    }

    private void removeFriendFromUser(User user, int friendId) {
        FriendNode prev = null;
        FriendNode current = user.friends;
        while (current != null) {
            if (current.friendId == friendId) {
                if (prev == null) {
                    user.friends = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            FriendNode friends1 = user1.friends;
            while (friends1 != null) {
                FriendNode friends2 = user2.friends;
                while (friends2 != null) {
                    if (friends1.friendId == friends2.friendId) {
                        System.out.println("Mutual Friend ID: " + friends1.friendId);
                    }
                    friends2 = friends2.next;
                }
                friends1 = friends1.next;
            }
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            FriendNode friends = user.friends;
            while (friends != null) {
                System.out.println("Friend ID: " + friends.friendId);
                friends = friends.next;
            }
        }
    }

    public void countFriends() {
        User temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode friends = temp.friends;
            while (friends != null) {
                count++;
                friends = friends.next;
            }
            System.out.println("User ID: " + temp.userId + " has " + count + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 27);
        sm.addUser(3, "Charlie", 30);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);

        System.out.println("Alice's Friends:");
        sm.displayFriends(1);

        System.out.println("Mutual Friends between Alice and Bob:");
        sm.findMutualFriends(1, 2);

        System.out.println("Number of Friends for each user:");
        sm.countFriends();

        sm.removeFriendConnection(1, 2);

        System.out.println("Alice's Friends after removing Bob:");
        sm.displayFriends(1);
    }
}
