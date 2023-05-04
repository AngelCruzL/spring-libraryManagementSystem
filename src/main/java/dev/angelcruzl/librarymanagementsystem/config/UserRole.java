package dev.angelcruzl.librarymanagementsystem.config;

public enum UserRole {
  /**
   * ADMIN: Can create, update, and delete books.
   * PUBLISHER: Can create and update books.
   * READ_ONLY: Can only read books.
   */
  ADMIN,
  PUBLISHER,
  READ_ONLY
}
