package services

import daos.UserDao
import models.User

import scala.concurrent.Future

class UserServiceImpl extends UserService {
  private val dao = new UserDao

  override def createUser(user: User) = {
    dao.insertUser(user)
  }

  override def updateUser(user: User) = {
    dao.updateUser(user)
  }

  override def deleteUser(userId: String): Future[Int] = {
    dao.deleteUser(userId)
  }

  override def getUserByUsername(username: String) = {
    dao.getUserByUsername(username)
  }

  override def getUsers(): Future[java.util.List[User]] = {
    dao.getUsers()
  }

}